package br.com.codemathsz.stage.services;

import br.com.codemathsz.stage.dtos.CreateUserDTO;
import br.com.codemathsz.stage.models.Users;
import br.com.codemathsz.stage.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    public Users createUser(CreateUserDTO user){
        var newUser = Users.builder()
                .name(user.name())
                .email(user.email())
                .password(user.password())
                .document(user.document())
                .birthDate(user.birthDate())
                .role_id(user.role_id())
                .build();
        return this.repository.save(newUser);
    }

    public List<Users> findAllUsers(){
        return this.repository.findAll();
    }
}
