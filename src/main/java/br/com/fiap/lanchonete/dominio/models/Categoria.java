package br.com.fiap.lanchonete.dominio.models;

import br.com.fiap.lanchonete.api.dto.response.CategoriaResponse;

public class Categoria {
    private int id;
    private String tipo;
    private String descricao;

    public Categoria(int id, String tipo, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public static CategoriaResponse toCategoriaResponse(Categoria categoria){
        return new CategoriaResponse(categoria.getId(), categoria.getTipo(), categoria.getDescricao());
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
