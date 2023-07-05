package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.models.Pedido;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PedidoRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.PedidoEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.exceptions.PedidoInexistenteException;
import org.springframework.stereotype.Component;

import java.util.List;
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
    public Pedido salvar(Pedido pedido) {
        final var entity = new PedidoEntity(pedido);
        final var pedidoCriado = repository.save(entity);
        return new Pedido(pedidoCriado);
    }

    @Override
    public Pedido buscarPorId(Integer pedidoId) {
        final var pedido = repository.findById(pedidoId);

        if(pedido.isEmpty()){
            throw new PedidoInexistenteException("Pedido não encontrado");
        }

        return new Pedido(pedido.get());
    }

}
