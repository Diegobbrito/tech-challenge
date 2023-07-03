package br.com.fiap.lanchonete.dominio.dtos.request;

public class ProdutoSelecionadoRequest {
    private Integer produtoId;
    private Integer quantidade;

    public Integer getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
