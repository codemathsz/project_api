package br.com.codemathsz.stage.controllers;

import br.com.codemathsz.stage.models.Project;
import br.com.codemathsz.stage.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping("/")
    public ResponseEntity<Project> createProject(@RequestBody Project newProject){
        var response = this.service.save(newProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
