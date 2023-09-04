package br.com.fiap.lanchonete.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;


public class ProdutoRequest {
    @Schema(example = "Hambúrguer SALAD")
    private String nome;
    @Schema(example = "Pão de brioche, hambúrguer Angus de 150g, alface, tomate e queijo mussarela")
    private String descricao;
    @Schema(example = "29,90")
    private BigDecimal valor;
    @Schema(example = "1")
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
