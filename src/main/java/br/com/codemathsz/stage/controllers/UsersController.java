package br.com.codemathsz.stage.controllers;

import br.com.codemathsz.stage.dtos.CreateUserDTO;
import br.com.codemathsz.stage.models.Users;
import br.com.codemathsz.stage.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping("/")
    public ResponseEntity<Users> createUser(@RequestBody CreateUserDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createUser(user));
    }

    @GetMapping("/")
    public ResponseEntity<List<Users>> users(){
        var users = this.service.findAllUsers();
        return ResponseEntity.ok().body(users);
    }
}
