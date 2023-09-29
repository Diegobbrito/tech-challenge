package br.com.fiap.lanchonete.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteResponse(
        @Schema(example = "05506902042")
        String cpf,
        @Schema(example = "Diego")
        String nome,
        @Schema(example = "diego@teste.com")
        String email) {
}
