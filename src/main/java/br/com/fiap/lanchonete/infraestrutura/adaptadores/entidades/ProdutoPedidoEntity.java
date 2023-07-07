package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.models.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedido_produto")
@Getter
@NoArgsConstructor
public class ProdutoPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    private int quantidade;

    public ProdutoPedidoEntity(PedidoEntity pedido, Produto produto, Integer quantidade) {
        this.pedido = pedido;
        this.produto= new ProdutoEntity(produto);
        this.quantidade = quantidade;
    }
}
