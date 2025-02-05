package br.com.codemathsz.stage.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record CreateMilestoneDTO(String name, LocalDate date, UUID projectPhaseId) {
}
