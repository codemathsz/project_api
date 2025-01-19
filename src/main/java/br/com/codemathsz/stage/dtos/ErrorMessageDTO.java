package br.com.codemathsz.stage.dtos;

import lombok.Builder;

@Builder
public record ErrorMessageDTO(String message, String field) {
}
