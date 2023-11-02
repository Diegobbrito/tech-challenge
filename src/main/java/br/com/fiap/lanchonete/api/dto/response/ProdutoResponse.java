package br.com.fiap.lanchonete.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ProdutoResponse (
        @Schema(example = "1")
        int id,
        @Schema(example = "Hambúrguer")
        String nome,
        @Schema(example = "Pão de brioche, hambúrguer Angus de 150g e queijo mussarela")
        String descricao,
        @Schema(example = "R$ 24,90")
        String valor, String imagemUrl){
}
