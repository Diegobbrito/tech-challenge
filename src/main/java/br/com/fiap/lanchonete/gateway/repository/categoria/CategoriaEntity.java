package br.com.fiap.lanchonete.gateway.repository.categoria;

import br.com.fiap.lanchonete.gateway.repository.produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
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
