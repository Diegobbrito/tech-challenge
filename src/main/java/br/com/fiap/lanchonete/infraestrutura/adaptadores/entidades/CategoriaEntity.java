package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.entidades.Categoria;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<ProdutoEntity> produtos;

    public Categoria toCategoria() {
        return new Categoria(this.id, this.titulo, this.descricao);
    }
}
