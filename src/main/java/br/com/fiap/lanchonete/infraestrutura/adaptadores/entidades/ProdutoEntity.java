package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.entidades.Categoria;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private String imagemUrl;

    @ManyToOne
    private CategoriaEntity categoria;

    public ProdutoEntity(Produto produto) {
         new ProdutoEntity(
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
        final var categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(categoria.getId());
        this.categoria = categoriaEntity;
        this.imagemUrl = imagemUrl;

    }

    public ProdutoEntity() {

    }

    public Produto toProduto() {

        return new Produto(this.id, this.nome, this.descricao, this.valor, new Categoria(this.categoria), this.imagemUrl);
    }
}
