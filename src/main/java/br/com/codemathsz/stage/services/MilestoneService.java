package br.com.codemathsz.stage.services;

import br.com.codemathsz.stage.dtos.CreateMilestoneDTO;
import br.com.codemathsz.stage.models.Milestone;
import br.com.codemathsz.stage.repositories.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilestoneService {

    @Autowired
    private MilestoneRepository repository;

    public Milestone create(CreateMilestoneDTO milestoneDTO){
        var milestone = Milestone.builder()
        .name(milestoneDTO.name())
        .date(milestoneDTO.date())
        .projectPhaseId(milestoneDTO.projectPhaseId())
        .build();
        return this.repository.save(milestone);
    }
}
