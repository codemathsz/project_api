package br.com.codemathsz.stage.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record CreateUserDTO(
     String name,
     String email,
     String password,
     LocalDate birthDate,
     String document,
     UUID role_id
) {
}
