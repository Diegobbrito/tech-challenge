package br.com.fiap.lanchonete.dominio.dtos.response;

public class CategoriaResponse {

    private int id;
    private String tipo;
    private String descricao;

    public CategoriaResponse(int id, String tipo, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }
}
