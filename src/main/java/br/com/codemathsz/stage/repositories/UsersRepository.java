package br.com.codemathsz.stage.repositories;

import br.com.codemathsz.stage.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
}
