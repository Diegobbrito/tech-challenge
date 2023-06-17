package br.com.fiap.lanchonete.dominio.dtos.request;

import br.com.fiap.lanchonete.dominio.enumerator.Categoria;

import java.math.BigDecimal;

public class ProdutoRequest {
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Categoria categoria;
    private String imagemUrl;
}
