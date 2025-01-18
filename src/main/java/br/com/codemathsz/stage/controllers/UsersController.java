package br.com.codemathsz.stage.controllers;

import br.com.codemathsz.stage.dtos.CreateUserDTO;
import br.com.codemathsz.stage.models.Users;
import br.com.codemathsz.stage.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping("/")
    public ResponseEntity<Users> createUser(@RequestBody CreateUserDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createUser(user));
    }
}
