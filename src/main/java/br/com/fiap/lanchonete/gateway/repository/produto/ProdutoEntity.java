package br.com.fiap.lanchonete.gateway.repository.produto;

import br.com.fiap.lanchonete.core.entity.Produto;
import br.com.fiap.lanchonete.gateway.repository.categoria.CategoriaEntity;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@NoArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoriaEntity categoria;

    public ProdutoEntity(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.categoria = new CategoriaEntity(produto.getCategoria().getId());
        this.imagemUrl = produto.getImagemUrl();
    }
}
