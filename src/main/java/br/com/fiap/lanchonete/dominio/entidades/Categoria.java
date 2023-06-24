package br.com.fiap.lanchonete.dominio.entidades;

import br.com.fiap.lanchonete.dominio.dtos.response.CategoriaResponse;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;

public class Categoria {
    private int id;
    private String tipo;
    private String descricao;

    public Categoria(int id, String tipo, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Categoria(CategoriaEntity categoria) {
        this.id = categoria.getId();
        this.tipo = categoria.getTitulo();
        this.descricao = categoria.getDescricao();
    }

    public Categoria(int categoriaId) {
        this.id = categoriaId;
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
