package br.com.codemathsz.stage.services;

import br.com.codemathsz.stage.dtos.CreateUserDTO;
import br.com.codemathsz.stage.dtos.UserAuthenticationDTO;
import br.com.codemathsz.stage.models.Users;
import br.com.codemathsz.stage.repositories.UsersRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class UsersService {

    @Value("${jwt.algorithm.secretKey}")
    private String secretKey;

    @Autowired
    private UsersRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users createUser(CreateUserDTO user){
        var newUser = Users.builder()
                .name(user.name())
                .email(user.email())
                .password(passwordEncoder.encode(user.password()))
                .document(user.document())
                .birthDate(user.birthDate())
                .role_id(user.role_id())
                .build();
        return this.repository.save(newUser);
    }

    public List<Users> findAllUsers(){
        return this.repository.findAll();
    }

    public String authUser(UserAuthenticationDTO authenticationDTO) throws AuthenticationException{
        var user = this.repository.findByEmail(authenticationDTO.email()).orElseThrow(
            () -> new RuntimeException("email/password incorrect")
        );

        var passwordMatches = this.passwordEncoder.matches(authenticationDTO.password(), user.getPassword());

        if(!passwordMatches){
            throw  new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
        .withIssuer("stage")
        .withSubject(user.getId().toString())
        .withClaim("ROLE", List.of(user.getRole().getName().toUpperCase()))
        .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
        .sign(algorithm);
    }
}
