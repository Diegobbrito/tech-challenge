package br.com.fiap.lanchonete.core.entity;

public class Categoria {
    private int id;
    private String tipo;
    private String descricao;

    public Categoria(int id) {
        this.id = id;
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
