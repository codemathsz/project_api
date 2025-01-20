package br.com.codemathsz.stage.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "project_phase")
@Data
public class ProjectPhase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "project_version_id", nullable = false)
    private ProjectVersion projectVersion;

    private String name;
    private Integer weeks;
    private String color;

    @Column(name = "is_independent")
    private Boolean isIndependent;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "phase_order")
    private Integer phaseOrder;

    @Column(name = "phase_type")
    @Enumerated(EnumType.STRING)
    private PhaseType phaseType;

    @OneToMany(mappedBy = "projectPhase")
    private List<Milestone> milestones;
}
