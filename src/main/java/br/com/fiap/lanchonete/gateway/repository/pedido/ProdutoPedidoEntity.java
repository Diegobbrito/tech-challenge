package br.com.fiap.lanchonete.gateway.repository.pedido;

import br.com.fiap.lanchonete.gateway.repository.produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedido_produto")
@Data
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

    private Integer quantidade;

    public ProdutoPedidoEntity(PedidoEntity pedido, ProdutoEntity produto, Integer quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }
}
