package br.com.codemathsz.stage.services;

import br.com.codemathsz.stage.models.Project;
import br.com.codemathsz.stage.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public Project save(Project newProject){
        return this.repository.save(newProject);
    }
}
