package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.dominio.enumerator.Categoria;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Categoria categoria;
    private String imagemUrl;
    private int quantidade;


    public Produto toProduto() {
        return new Produto(this.id, this.nome, this.descricao, this.valor, this.categoria, this.imagemUrl, this.quantidade);
    }
}
