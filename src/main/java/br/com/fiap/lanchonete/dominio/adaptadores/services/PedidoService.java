package br.com.fiap.lanchonete.dominio.adaptadores.services;

import br.com.fiap.lanchonete.dominio.dtos.request.PagamentoRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.PedidoRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.PedidoStatusRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoSelecionadoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.PedidoResponse;
import br.com.fiap.lanchonete.dominio.enumerator.StatusEnum;
import br.com.fiap.lanchonete.dominio.models.Cliente;
import br.com.fiap.lanchonete.dominio.models.Pedido;
import br.com.fiap.lanchonete.dominio.models.Status;
import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ClienteRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PagamentoDataProviderPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PedidoRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepository;
    private final ClienteRepositoryPort clienteRepository;
    private final ProdutoRepositoryPort produtoRepository;

    private final PagamentoDataProviderPort pagamentoDataProvider;

    public PedidoService(PedidoRepositoryPort repository, ClienteRepositoryPort clienteRepository, ProdutoRepositoryPort produtoRepository, PagamentoDataProviderPort pagamentoDataProvider) {
        this.pedidoRepository = repository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.pagamentoDataProvider = pagamentoDataProvider;
    }

    @Override
    public List<PedidoResponse> buscarTodos() {
        final var pedidos = this.pedidoRepository.buscarTodos();
        return pedidos.stream().map(Pedido::toResponse).collect(Collectors.toList());
    }

    @Override
    public PedidoResponse criar(PedidoRequest request) {
        Pedido pedido;

        final var ids = request.getProdutos().stream().map(ProdutoSelecionadoRequest::getProdutoId).collect(Collectors.toList());
        final var produtos = this.produtoRepository.buscarTodosPorIds(ids);

        final var status = new Status(StatusEnum.PAGAMENTOPENDENTE);
        Cliente cliente = null;
        if(request.isCliente() && request.getClienteId() != null){
            cliente = this.clienteRepository.buscarClientePorId(request.getClienteId());
        }
        pedido = new Pedido(request, cliente, produtos, status);

        final var entity = pedidoRepository.salvar(pedido);
        return Pedido.toResponse(entity);
    }

    @Override
    public PedidoResponse pagar(Integer pedidoId, PagamentoRequest request) {
        final var pedido = pedidoRepository.buscarPorId(pedidoId);
        final var checkPagamento = this.pagamentoDataProvider.realizarPagamento(request.getHash());

        if(checkPagamento){
            pedido.setStatus(StatusEnum.RECEBIDO);
        }

        final var entity = pedidoRepository.salvar(pedido);
        return Pedido.toResponse(entity);
    }

    @Override
    public PedidoResponse atualizar(Integer pedidoId, PedidoStatusRequest request) {
        final var pedido = pedidoRepository.buscarPorId(pedidoId);
        pedido.setStatus(StatusEnum.from(request.getStatusId()));
        final var entity = pedidoRepository.salvar(pedido);
        return Pedido.toResponse(entity);
    }

    @Override
    public PedidoResponse consultarStatusDePagamento() {
        return null;
    }
}
