package br.com.codemathsz.stage.dtos;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record CreateProjectVersionDTO(
        UUID projectId,
        String version,
        String title,
        String address,
        String district,
        String city,
        String state,
        LocalDate startDate,
        LocalDate constructionStartDate
) {
}