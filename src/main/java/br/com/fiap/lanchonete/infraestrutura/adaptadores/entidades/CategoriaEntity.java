package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Table;

import java.util.List;

@Entity
@Table(appliesTo = "categoria")
@Getter
@Setter
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descrição;

    @OneToMany(mappedBy = "categoria")
    private List<ProdutoEntity> produtos;
}
