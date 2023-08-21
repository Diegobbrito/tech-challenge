package br.com.fiap.lanchonete.gateway.pedido;

import br.com.fiap.lanchonete.core.enumerator.StatusEnum;
import br.com.fiap.lanchonete.core.entity.Pedido;
import br.com.fiap.lanchonete.gateway.repository.IPedidoRepository;
import br.com.fiap.lanchonete.core.exception.PedidoInexistenteException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoRepository implements IPedidoRepository {

    private final JpaPedidoRepository repository;

    public PedidoRepository(JpaPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pedido> buscarTodos() {
        final var pedidos = repository.findAll();
        repository.findByStatusIn(List.of(
                new StatusPedidoEntity(StatusEnum.PRONTO),
                new StatusPedidoEntity(StatusEnum.PREPARANDO),
                new StatusPedidoEntity(StatusEnum.RECEBIDO)));
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
