package br.com.fiap.lanchonete.core.usecase.pedido;

import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.core.entity.Pedido;
import br.com.fiap.lanchonete.gateway.repository.IPedidoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BuscarPedidoUseCase implements IBuscarPedido {

    private final IPedidoRepository pedidoRepository;

    public BuscarPedidoUseCase(IPedidoRepository repository) {
        this.pedidoRepository = repository;

    }

    @Override
    public List<PedidoResponse> buscarTodos() {
        final var pedidos = this.pedidoRepository.buscarTodos();
        return pedidos.stream().map(Pedido::toResponse).collect(Collectors.toList());
    }
}
