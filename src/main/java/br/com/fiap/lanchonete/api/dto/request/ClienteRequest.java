package br.com.fiap.lanchonete.api.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteRequest(
        @Schema(example = "Diego")
        String nome,
        @Schema(example = "diego@postech.com")
        String email,
        @Schema(example = "055.069.020-42")
        String cpf
) {
}
