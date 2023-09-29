package br.com.fiap.lanchonete.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;


public record ProdutoRequest (
        @Schema(example = "Hambúrguer SALAD")
        String nome,
        @Schema(example = "Pão de brioche, hambúrguer Angus de 150g, alface, tomate e queijo mussarela")
        String descricao,
        @Schema(example = "29,90")
        BigDecimal valor,
        @Schema(example = "1")
        Integer categoriaId,
        String imagemUrl) {
}
