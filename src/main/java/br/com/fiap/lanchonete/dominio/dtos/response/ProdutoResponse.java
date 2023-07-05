package br.com.fiap.lanchonete.dominio.dtos.response;

public class ProdutoResponse {
    private int id;
    private String nome;
    private String descricao;
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
