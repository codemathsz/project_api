package br.com.codemathsz.stage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "project_version")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    @JsonIgnore
    private Project project;
    @Column(name = "project_id", nullable = false)
    private UUID projectId;

    private String version;
    private String title;
    private String address;
    private String district;
    private String city;
    private String state;

    private LocalDateTime updatedAt;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "construction_start_date")
    private LocalDate constructionStartDate;

    @OneToMany(mappedBy = "projectVersion")
    private List<ProjectPhase> phases;
}
