package br.com.hellosol.hellosol.dto;

import lombok.Builder;

@Builder
public record TokenResponseDTO(String token, String refreshToken) {
}