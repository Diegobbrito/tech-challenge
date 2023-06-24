package br.com.fiap.lanchonete.dominio.entidades;



import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Categoria categoria;
    private String imagemUrl;


    public Produto(Long id, String nome, String descricao, BigDecimal valor, Categoria categoria, String imagemUrl) {
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
}
