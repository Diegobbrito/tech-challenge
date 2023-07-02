package br.com.fiap.lanchonete.dominio.adaptadores.services;

import br.com.fiap.lanchonete.dominio.dtos.request.PedidoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.PedidoResponse;
import br.com.fiap.lanchonete.dominio.entidades.Pedido;
import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PedidoRepositoryPort;

import java.util.List;

public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort repository;

    public PedidoService(PedidoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<PedidoResponse> buscarTodos() {
        return null;
    }

    @Override
    public void criar(PedidoRequest request) {
        final var pedido = new Pedido();
        repository.criar(pedido);
    }
}
