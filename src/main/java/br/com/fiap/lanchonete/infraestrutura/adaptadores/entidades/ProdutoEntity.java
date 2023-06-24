package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.entidades.Categoria;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Nonnull
    private String nome;
    @Nonnull
    private String descricao;
    @Nonnull
    private BigDecimal valor;

    private String imagemUrl;

    @ManyToOne
    private CategoriaEntity categoria;

    public ProdutoEntity(Produto produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        final var categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(produto.getCategoria().getId());
        this.categoria = categoriaEntity;
        this.imagemUrl = produto.getImagemUrl();
    }

    public ProdutoEntity() {

    }

    public Produto toProduto() {
        return new Produto(this.id, this.nome, this.descricao, this.valor, new Categoria(this.categoria), this.imagemUrl);
    }
}
