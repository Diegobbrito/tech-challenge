package br.com.fiap.lanchonete.gateway.repository.categoria;

import br.com.fiap.lanchonete.gateway.repository.produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    private List<ProdutoEntity> produtos = new ArrayList<>();

    public CategoriaEntity(int categoriaId) {
        this.id = categoriaId;
    }


}
