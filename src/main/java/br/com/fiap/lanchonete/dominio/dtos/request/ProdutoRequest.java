package br.com.fiap.lanchonete.dominio.dtos.request;

import br.com.fiap.lanchonete.dominio.enumerator.Categoria;

import java.math.BigDecimal;

public class ProdutoRequest {
    private String nome;
    private String descricao;
    private BigDecimal valor;

    private int categoriaId;
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
