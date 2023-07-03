package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Pedido;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PedidoRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.PedidoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoRepository implements PedidoRepositoryPort {

    private final SpringPedidoRepository repository;

    public PedidoRepository(SpringPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pedido> buscarTodos() {
        final var pedidos = repository.findAll();
        return null;
    }

    @Override
    public void criar(Pedido pedido) {
        final var entity = new PedidoEntity(pedido);
        repository.save(entity);
    }

}
