package br.com.codemathsz.stage.repositories;

import br.com.codemathsz.stage.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

    Optional<List<Project>> findByUserId(UUID userId);

    List<Project> findByCodContainingIgnoreCase(String filter);
}
