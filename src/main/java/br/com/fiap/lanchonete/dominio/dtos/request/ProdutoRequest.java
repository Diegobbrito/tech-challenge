package br.com.fiap.lanchonete.dominio.dtos.request;

import java.math.BigDecimal;


public class ProdutoRequest {
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Integer categoriaId;
    private String imagemUrl;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
