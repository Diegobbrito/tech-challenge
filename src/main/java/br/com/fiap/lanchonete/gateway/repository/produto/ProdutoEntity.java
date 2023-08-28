package br.com.fiap.lanchonete.gateway.repository.produto;

import br.com.fiap.lanchonete.api.dto.request.ProdutoRequest;
import br.com.fiap.lanchonete.core.entity.Categoria;
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
        if(produto.getId() != null)
            this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.categoria = new CategoriaEntity(produto.getCategoria().getId());
        this.imagemUrl = produto.getImagemUrl();
    }

    public Produto toProduto() {
        return new Produto(this.id, this.nome, this.descricao, this.valor, toCategoria(this.categoria), this.imagemUrl);
    }

    public Produto toProduto(ProdutoRequest request) {
        if(request.getNome() != null || request.getNome().isBlank())
            this.nome = request.getNome();
        if(request.getDescricao() != null || request.getDescricao().isBlank())
            this.descricao = request.getDescricao();
        if(request.getValor() != null)
            this.valor = request.getValor();
        if(request.getImagemUrl() != null|| request.getImagemUrl().isBlank())
            this.imagemUrl = request.getImagemUrl();
        return new Produto(this.id,this.nome, this.descricao, this.valor, toCategoria(this.categoria), this.imagemUrl);
    }

    public Categoria toCategoria(CategoriaEntity categoria) {
        return new Categoria(categoria.getId(), categoria.getTitulo(), categoria.getDescricao());
    }
}
