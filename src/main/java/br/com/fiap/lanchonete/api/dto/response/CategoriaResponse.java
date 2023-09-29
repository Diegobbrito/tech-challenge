package br.com.fiap.lanchonete.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record CategoriaResponse(
        @Schema(example = "4")
        int id,
        @Schema(example = "Sobremesas")
        String tipo,
        @Schema(example = "Sorvetes e doces váriados")
        String descricao) {
}
