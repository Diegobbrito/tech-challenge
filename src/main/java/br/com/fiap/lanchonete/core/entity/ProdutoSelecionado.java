package br.com.fiap.lanchonete.core.entity;

public class ProdutoSelecionado {
    private Produto produto;
    private Integer quantidade;

    public ProdutoSelecionado(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
