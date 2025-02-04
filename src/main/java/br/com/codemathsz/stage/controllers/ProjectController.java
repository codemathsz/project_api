package br.com.codemathsz.stage.controllers;

import br.com.codemathsz.stage.dtos.CreateProjectDTO;
import br.com.codemathsz.stage.dtos.UpdateProjectDTO;
import br.com.codemathsz.stage.models.Project;
import br.com.codemathsz.stage.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping("/")
    public ResponseEntity<Project> createProject(@RequestBody CreateProjectDTO newProject){
        var response = this.service.save(newProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable String id, @RequestBody UpdateProjectDTO newProject){
        var response = this.service.update(id,newProject);
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable String id){
        var project = this.service.findById(id);
        return ResponseEntity.ok().body(project);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Project>> getProjectByUserId(@PathVariable String userId){
        return ResponseEntity.ok().body(this.service.findByUserId(userId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Project>> getProjects(){
        var projects = this.service.findAll();
        return ResponseEntity.ok().body(projects);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> softDelete(@PathVariable String id){
        return ResponseEntity.ok().body(this.service.softDelete(id));
    }
}
