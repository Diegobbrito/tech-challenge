package br.com.fiap.lanchonete.core.entity;

public class Categoria {
    private int id;
    private String tipo;
    private String descricao;

    public Categoria(int id, String tipo, String descricao) {
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
