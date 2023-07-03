package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.entidades.*;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "pedidos")
@Getter
@NoArgsConstructor
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido.id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<ProdutoPedidoEntity> produtos;

    private BigDecimal valor;

    @ManyToOne
    private ClienteEntity cliente;
    private boolean isCliente;
    private LocalDateTime data_criacao;

    @ManyToOne
    private StatusPedidoEntity status;

    public PedidoEntity(Pedido pedido) {
        this.isCliente = pedido.isCliente();
        if(pedido.isCliente()){
            final var cliente =  new ClienteEntity();
            cliente.setId(pedido.getCliente().getId());
            this.cliente = cliente;
        }
        this.valor = pedido.getValor();
        final var status = new StatusPedidoEntity();
        status.setId(pedido.getStatus().getId());
        this.status = status;
        this.data_criacao = LocalDateTime.now();
        this.produtos = pedido.getProdutos().stream().map(p ->
             new ProdutoPedidoEntity(this, p.getProduto(), p.getQuantidade())
        ).collect(Collectors.toList());
    }

}
