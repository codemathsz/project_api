package br.com.codemathsz.stage.repositories;

import br.com.codemathsz.stage.models.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MilestoneRepository extends JpaRepository<Milestone, UUID> {
}
