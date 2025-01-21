package br.com.codemathsz.stage.dtos;

import br.com.codemathsz.stage.models.PhaseType;

import java.time.LocalDate;
import java.util.UUID;

public record CreateProjectPhaseDTO(
        String name,
        Integer weeks,
        Boolean isIndependent,
        LocalDate startDate,
        LocalDate independentDate,
        Integer phaseOrder,
        PhaseType phaseType,
        UUID projectVersionId
) {
}