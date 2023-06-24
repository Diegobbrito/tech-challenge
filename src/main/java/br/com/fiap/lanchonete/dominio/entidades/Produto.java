package br.com.fiap.lanchonete.dominio.entidades;



import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Produto {
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Categoria categoria;
    private String imagemUrl;


    public Produto(Integer id, String nome, String descricao, BigDecimal valor, Categoria categoria, String imagemUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
    }

    public Produto(String nome, String descricao, BigDecimal valor, String imagemUrl, Categoria categoria) {
        this.nome = nome.trim();
        this.descricao = descricao.trim();
        this.valor = valor.setScale(2, RoundingMode.HALF_UP);
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
    }

    public Integer getId() {
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

    public static ProdutoResponse toProdutoResponse(Produto produto) {
        final var valorDoProduto = formatarParaReal(produto.getValor());
        return new ProdutoResponse(produto.getId(),  produto.getNome(), produto.getDescricao(), valorDoProduto , produto.getImagemUrl());
    }

    private static String formatarParaReal(BigDecimal valor){
        return "R$" + new DecimalFormat("#,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR"))).format(valor);
    }
}
