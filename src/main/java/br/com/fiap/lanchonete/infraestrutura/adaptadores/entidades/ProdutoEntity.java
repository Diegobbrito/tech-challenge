package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.dominio.enumerator.Categoria;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Categoria categoria;
    private String imagemUrl;

    public ProdutoEntity(Produto produto) {
        final var entity = new ProdutoEntity(
                produto.getNome(),
                produto.getDescricao(),
                produto.getValor(),
                produto.getCategoria(),
                produto.getImagemUrl());
    }

    public ProdutoEntity(String nome, String descricao, BigDecimal valor, Categoria categoria, String imagemUrl) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;

    }

    public Produto toProduto() {
        return new Produto(this.id, this.nome, this.descricao, this.valor, this.categoria, this.imagemUrl);
    }
}
