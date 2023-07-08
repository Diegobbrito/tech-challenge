package br.com.fiap.lanchonete.dominio.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProdutoSelecionadoRequest {
    @Schema(example = "1")
    private Integer produtoId;
    @Schema(example = "1")
    private Integer quantidade;

    public Integer getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
