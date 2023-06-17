package br.com.fiap.lanchonete.dominio.entidades;

import br.com.fiap.lanchonete.dominio.enumerator.Categoria;

import java.math.BigDecimal;

public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Categoria categoria;
    private String imagemUrl;
    private int quantidade;

    public Produto(Long id, String nome, String descricao, BigDecimal valor, Categoria categoria, String imagemUrl, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
        this.quantidade = quantidade;
    }

    public Produto() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
