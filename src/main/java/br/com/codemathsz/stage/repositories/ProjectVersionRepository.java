package br.com.codemathsz.stage.repositories;

import br.com.codemathsz.stage.models.ProjectVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectVersionRepository extends JpaRepository<ProjectVersion, UUID> {
}