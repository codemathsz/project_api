package br.com.codemathsz.stage.repositories;

import br.com.codemathsz.stage.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<Role, UUID> {
}