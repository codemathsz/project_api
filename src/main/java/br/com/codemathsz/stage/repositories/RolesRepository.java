package br.com.codemathsz.stage.repositories;

import br.com.codemathsz.stage.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<Roles, UUID> {
}