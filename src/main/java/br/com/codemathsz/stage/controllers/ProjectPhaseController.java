package br.com.codemathsz.stage.controllers;

import br.com.codemathsz.stage.dtos.CreateProjectPhaseDTO;
import br.com.codemathsz.stage.models.ProjectPhase;
import br.com.codemathsz.stage.services.ProjectPhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project/version")
public class ProjectPhaseController {

    @Autowired
    private ProjectPhaseService service;

    @PostMapping("/phase")
    public ResponseEntity<ProjectPhase> create(@RequestBody CreateProjectPhaseDTO projectPhaseDTO){
        var newProjectPhase = this.service.save(projectPhaseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProjectPhase);
    }
}