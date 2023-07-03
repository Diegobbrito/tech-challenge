package br.com.fiap.lanchonete.dominio.adaptadores.services;

import br.com.fiap.lanchonete.dominio.dtos.request.PedidoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.PedidoResponse;
import br.com.fiap.lanchonete.dominio.entidades.Pedido;
import br.com.fiap.lanchonete.dominio.entidades.Status;
import br.com.fiap.lanchonete.dominio.enumerator.StatusEnum;
import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ClienteRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PedidoRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort repository;
    private final ClienteRepositoryPort clienteRepository;

    private final ProdutoRepositoryPort produtoRepository;

    public PedidoService(PedidoRepositoryPort repository, ClienteRepositoryPort clienteRepository, ProdutoRepositoryPort produtoRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<PedidoResponse> buscarTodos() {
        return null;
    }

    @Override
    public void criar(PedidoRequest request) {
        Pedido pedido = null;

        final var produtos = this.produtoRepository.buscarTodosPorIds(new ArrayList<>(request.getProdutos().keySet()));

        final var status = new Status(StatusEnum.PAGAMENTOPENDENTE);
        if(request.isCliente()){
            final var cliente = this.clienteRepository.buscarClientePorId(request.getClienteId());
            pedido = new Pedido(request, cliente, produtos, status);
        }
        else{
            pedido = new Pedido(request, produtos, status);
        }

        repository.criar(pedido);
    }
}
