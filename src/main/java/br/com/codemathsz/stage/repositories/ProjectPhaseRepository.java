package br.com.codemathsz.stage.repositories;

import br.com.codemathsz.stage.models.ProjectPhase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectPhaseRepository extends JpaRepository<ProjectPhase, UUID> {
}