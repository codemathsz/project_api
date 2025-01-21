package br.com.codemathsz.stage.services;

import br.com.codemathsz.stage.dtos.CreateProjectVersionDTO;
import br.com.codemathsz.stage.models.ProjectVersion;
import br.com.codemathsz.stage.repositories.ProjectVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectVersionService {

    @Autowired
    private ProjectVersionRepository repository;

    public ProjectVersion create(CreateProjectVersionDTO projectVersionDTO){
        var newProjectVersion = ProjectVersion.builder()
            .projectId(projectVersionDTO.projectId())
            .version(projectVersionDTO.version())
            .title(projectVersionDTO.title())
            .address(projectVersionDTO.address())
            .district(projectVersionDTO.district())
            .city(projectVersionDTO.city())
            .state(projectVersionDTO.state())
            .startDate(projectVersionDTO.startDate())
            .constructionStartDate(projectVersionDTO.constructionStartDate())
        .build();
        return this.repository.save(newProjectVersion);
    }
}