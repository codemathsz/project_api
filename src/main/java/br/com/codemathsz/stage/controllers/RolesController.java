package br.com.codemathsz.stage.controllers;

import br.com.codemathsz.stage.models.Role;
import br.com.codemathsz.stage.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService service;

    @PostMapping("/")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        var newRole = this.service.create(role);

        return ResponseEntity.status(HttpStatus.CREATED).body(newRole);
    }

    @GetMapping("/")
    public ResponseEntity<List<Role>> roles(){
        var allRoles = this.service.getAllRoles();
        return ResponseEntity.ok().body(allRoles);
    }
}