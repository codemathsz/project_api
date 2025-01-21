package br.com.codemathsz.stage.services;

import br.com.codemathsz.stage.dtos.CreateProjectPhaseDTO;
import br.com.codemathsz.stage.models.ProjectPhase;
import br.com.codemathsz.stage.repositories.ProjectPhaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectPhaseService {

    @Autowired
    private ProjectPhaseRepository repository;

    public ProjectPhase save(CreateProjectPhaseDTO projectPhaseDTO){
        var newProjectPhase = ProjectPhase.builder()
            .name(projectPhaseDTO.name())
            .weeks(projectPhaseDTO.weeks())
            .isIndependent(projectPhaseDTO.isIndependent())
            .startDate(projectPhaseDTO.startDate())
            .independentDate(projectPhaseDTO.independentDate())
            .phaseOrder(projectPhaseDTO.phaseOrder())
            .phaseType(projectPhaseDTO.phaseType())
            .projectVersionId(projectPhaseDTO.projectVersionId())
        .build();
        return this.repository.save(newProjectPhase);
    }
}