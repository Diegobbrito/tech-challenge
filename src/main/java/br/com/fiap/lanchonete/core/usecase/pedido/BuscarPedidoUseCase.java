package br.com.fiap.lanchonete.core.usecase.pedido;

import br.com.fiap.lanchonete.api.adapter.PedidoAdapter;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.config.UseCase;
import br.com.fiap.lanchonete.gateway.repository.IPedidoRepository;

import java.util.List;
import java.util.stream.Collectors;
@UseCase
public class BuscarPedidoUseCase implements IBuscarPedido {

    private final IPedidoRepository pedidoRepository;

    public BuscarPedidoUseCase(IPedidoRepository repository) {
        this.pedidoRepository = repository;

    }

    @Override
    public List<PedidoResponse> buscarTodos() {
        final var pedidos = this.pedidoRepository.buscarTodos();
        return pedidos.stream().map(PedidoAdapter::toResponse).collect(Collectors.toList());
    }
}
