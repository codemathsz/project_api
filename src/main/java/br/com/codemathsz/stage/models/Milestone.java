package br.com.codemathsz.stage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "milestone")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "project_phase_id", insertable = false, updatable = false)
    @JsonIgnore
    private ProjectPhase projectPhase;
    @Column(name = "project_phase_id", nullable = false)
    private UUID projectPhaseId;
    private String name;
    private LocalDate date;
}
