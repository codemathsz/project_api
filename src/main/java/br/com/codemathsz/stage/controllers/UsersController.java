package br.com.codemathsz.stage.controllers;

import br.com.codemathsz.stage.dtos.CreateUserDTO;
import br.com.codemathsz.stage.dtos.UserAuthenticationDTO;
import br.com.codemathsz.stage.models.User;
import br.com.codemathsz.stage.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createUser(user));
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> users(){
        var users = this.service.findAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        var users = this.service.findById(id);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody UserAuthenticationDTO authenticationDTO){
        System.out.println("CHAMOU"+ authenticationDTO);
        try{
            var token = this.service.authUser(authenticationDTO);
            return ResponseEntity.ok().body(token);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
