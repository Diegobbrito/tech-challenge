package br.com.fiap.lanchonete.usecase.pedido;

import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.dominio.models.Pedido;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PedidoRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class BuscarPedidoUseCase implements IBuscarPedido {

    private final PedidoRepositoryPort pedidoRepository;

    public BuscarPedidoUseCase(PedidoRepositoryPort repository) {
        this.pedidoRepository = repository;

    }

    @Override
    public List<PedidoResponse> buscarTodos() {
        final var pedidos = this.pedidoRepository.buscarTodos();
        return pedidos.stream().map(Pedido::toResponse).collect(Collectors.toList());
    }
}
