package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.enumerator.StatusEnum;
import br.com.fiap.lanchonete.dominio.models.Categoria;
import br.com.fiap.lanchonete.dominio.models.Pedido;
import br.com.fiap.lanchonete.dominio.models.Produto;
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

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ProdutoPedidoEntity> produtos;

    private BigDecimal valor;

    @ManyToOne
    private ClienteEntity cliente;
    private boolean isCliente;
    private LocalDateTime dataCriacao;

    @ManyToOne
    private StatusPedidoEntity status;

    public PedidoEntity(Pedido pedido) {
        this.id = pedido.getId();
        this.isCliente = pedido.isCliente();
        if(pedido.isCliente()){
            final var cliente =  new ClienteEntity();
            cliente.setId(pedido.getCliente().getId());
            this.cliente = cliente;
        }
        this.valor = pedido.getValor();
        this.status = new StatusPedidoEntity(StatusEnum.from(pedido.getStatus().getId()));
        this.dataCriacao = LocalDateTime.now();
        this.produtos = pedido.getProdutos().stream().map(p ->
             new ProdutoPedidoEntity(this, p.getProduto(), p.getQuantidade())
        ).collect(Collectors.toList());
    }

    public Pedido toPedido() {
        return new Pedido(this);
    }

    public boolean isCliente() {
        return isCliente;
    }
}
