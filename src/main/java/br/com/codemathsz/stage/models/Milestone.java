package br.com.codemathsz.stage.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "milestone")
@Data
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "project_phase_id")
    private ProjectPhase projectPhase;

    private String name;
    private LocalDate date;
}
