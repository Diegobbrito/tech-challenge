package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.entidades.Pedido;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
import jakarta.persistence.*;

@Entity
@Table(name = "pedido_produto")
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

    private Integer quantidade;

    public ProdutoPedidoEntity(PedidoEntity pedido, Produto produto, Integer quantidade) {
        this.pedido = pedido;
        this.produto= new ProdutoEntity(produto);
        this.quantidade = quantidade;
    }
}
