package br.com.codemathsz.stage.services;

import br.com.codemathsz.stage.dtos.CreateProjectDTO;
import br.com.codemathsz.stage.dtos.UpdateProjectDTO;
import br.com.codemathsz.stage.exceptions.ProjectNotFoundException;
import br.com.codemathsz.stage.models.Project;
import br.com.codemathsz.stage.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public Project save(CreateProjectDTO projectDTO){
        var newProject = Project.builder()
                .cod(projectDTO.cod())
                .userId(projectDTO.userId())
                .build();
        return this.repository.save(newProject);
    }

    public Project update(String id, UpdateProjectDTO updateProjectDTO){
        var project = this.repository.findById(UUID.fromString(id)).orElseThrow(ProjectNotFoundException::new);
        project.setCod(updateProjectDTO.cod());
        return this.repository.save(project);
    }

    public List<Project> findByUserId(String userId){
        return this.repository.findByUserId(UUID.fromString(userId)).orElseThrow(
            () -> new RuntimeException("User not found")
        );
    }

    public Project findById(String id){
        return this.repository.findById(UUID.fromString(id)).orElseThrow(
            () -> new RuntimeException("Project not found")
        );
    }

    public List<Project> findByCod(String filter){
        return this.repository.findByCodContainingIgnoreCase(filter);
    }

    public Project softDelete(String id){
        var project = repository.findById(UUID.fromString(id)).orElseThrow(
                () -> new RuntimeException("Project not found")
        );
        project.setDeletedAt(LocalDateTime.now());
        return repository.save(project);
    }
}
