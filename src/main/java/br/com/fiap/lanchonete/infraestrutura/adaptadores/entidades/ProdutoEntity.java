package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.models.Categoria;
import br.com.fiap.lanchonete.dominio.models.Produto;
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

    @ManyToOne
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
        return new Produto(this.id, this.nome, this.descricao, this.valor, new Categoria(this.categoria), this.imagemUrl);
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

        this.categoria = new CategoriaEntity(request.getCategoriaId());
        return new Produto(this.id,this.nome, this.descricao, this.valor, new Categoria(this.categoria), this.imagemUrl);
    }
}
