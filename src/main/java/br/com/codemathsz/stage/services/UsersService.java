package br.com.codemathsz.stage.services;

import br.com.codemathsz.stage.dtos.CreateUserDTO;
import br.com.codemathsz.stage.dtos.UserAuthenticationDTO;
import br.com.codemathsz.stage.models.User;
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
import java.util.UUID;

@Service
public class UsersService {

    @Value("${jwt.algorithm.secretKey}")
    private String secretKey;

    @Autowired
    private UsersRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(CreateUserDTO user){
        var newUser = User.builder()
                .name(user.name())
                .email(user.email())
                .password(passwordEncoder.encode(user.password()))
                .document(user.document())
                .birthDate(user.birthDate())
                .role_id(user.role_id())
                .build();
        return this.repository.save(newUser);
    }

    public List<User> findAllUsers(){
        return this.repository.findAll();
    }

    public String authUser(UserAuthenticationDTO authenticationDTO) throws AuthenticationException{
        var user = this.repository.findByEmail(authenticationDTO.email()).orElseThrow(
            () -> new RuntimeException("E-mail ou senha incorreto.")
        );

        var passwordMatches = this.passwordEncoder.matches(authenticationDTO.password(), user.getPassword());

        if(!passwordMatches){
            throw  new AuthenticationException();
        }

        Instant now = Instant.now();
        Instant expiresAt = now.plus(Duration.ofDays(7));

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
        .withIssuer("stage")
        .withSubject(user.getId().toString())
        .withClaim("ROLE", List.of(user.getRole().getName().toUpperCase()))
        .withExpiresAt(expiresAt)
        .sign(algorithm);
    }

    public User findById(String id){
        var user = this.repository.findById(UUID.fromString(id)).orElseThrow(
                () -> new RuntimeException("user not found")
        );
        return user;
    }
}
