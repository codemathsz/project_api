package br.com.codemathsz.stage.controllers;

import br.com.codemathsz.stage.dtos.CreateProjectVersionDTO;
import br.com.codemathsz.stage.models.ProjectVersion;
import br.com.codemathsz.stage.services.ProjectVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/project")
public class ProjectVersionController {

    @Autowired
    private ProjectVersionService service;

    @PostMapping("/version")
    public ResponseEntity<ProjectVersion> create(@RequestBody CreateProjectVersionDTO projectVersionDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.service.create(projectVersionDTO));
    }
}