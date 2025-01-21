package br.com.codemathsz.stage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "project_phase")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectPhase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "project_version_id", insertable = false, updatable = false)
    @JsonIgnore
    private ProjectVersion projectVersion;
    @Column(name = "project_version_id", nullable = false)
    private UUID projectVersionId;
    private String name;
    private Integer weeks;

    @Column(name = "is_independent")
    private Boolean isIndependent;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "independent_date")
    private LocalDate independentDate;
    @Column(name = "phase_order")
    private Integer phaseOrder;

    @Column(name = "phase_type")
    @Enumerated(EnumType.STRING)
    private PhaseType phaseType;

    @OneToMany(mappedBy = "projectPhase")
    private List<Milestone> milestones;
}
