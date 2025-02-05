package br.com.codemathsz.stage.controllers;

import br.com.codemathsz.stage.dtos.CreateMilestoneDTO;
import br.com.codemathsz.stage.models.Milestone;
import br.com.codemathsz.stage.repositories.MilestoneRepository;
import br.com.codemathsz.stage.services.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/milestone")
public class MilestoneController {

    @Autowired
    private MilestoneService service;

    @PostMapping("")
    public Milestone create(@RequestBody CreateMilestoneDTO milestoneDTO){
        return this.service.create(milestoneDTO);
    }
}
