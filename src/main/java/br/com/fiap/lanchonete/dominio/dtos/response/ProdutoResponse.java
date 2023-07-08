package br.com.fiap.lanchonete.dominio.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProdutoResponse {
    @Schema(example = "1")
    private int id;
    @Schema(example = "Hambúrguer")
    private String nome;
    @Schema(example = "Pão de brioche, hambúrguer Angus de 150g e queijo mussarela")
    private String descricao;
    @Schema(example = "R$ 24,90")
    private String valor;
    private String imagemUrl;

    public ProdutoResponse(int id, String nome, String descricao, String valor, String imagemUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.imagemUrl = imagemUrl;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getValor() {
        return valor;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
