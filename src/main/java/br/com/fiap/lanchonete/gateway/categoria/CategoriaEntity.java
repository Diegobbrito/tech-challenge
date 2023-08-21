package br.com.fiap.lanchonete.gateway.categoria;

import br.com.fiap.lanchonete.core.entity.Categoria;
import br.com.fiap.lanchonete.gateway.produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<ProdutoEntity> produtos;

    public CategoriaEntity(int categoriaId) {
        this.id = categoriaId;
    }

    public Categoria toCategoria() {
        return new Categoria(this.id, this.titulo, this.descricao);
    }
}
