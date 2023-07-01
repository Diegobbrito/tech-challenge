package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Pedido;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PedidoRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.PedidoEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PedidoRepository implements PedidoRepositoryPort {

    private final SpringPedidoRepository repository;

    public PedidoRepository(SpringPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pedido> buscarTodos() {
        final var pedidos = repository.findAll();
        return pedidos.stream().map(PedidoEntity::toPedido).collect(Collectors.toList());
    }

    @Override
    public void salvar(Pedido pedido) {
        final var entity = new PedidoEntity(pedido);
        repository.save(entity);
    }

}
