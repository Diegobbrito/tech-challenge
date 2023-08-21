package br.com.fiap.lanchonete.core.usecase.pedido;

import br.com.fiap.lanchonete.api.dto.request.PedidoRequest;
import br.com.fiap.lanchonete.api.dto.request.ProdutoSelecionadoRequest;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.core.enumerator.StatusEnum;
import br.com.fiap.lanchonete.core.entity.Cliente;
import br.com.fiap.lanchonete.core.entity.Pedido;
import br.com.fiap.lanchonete.core.entity.Status;
import br.com.fiap.lanchonete.gateway.repository.IClienteRepository;
import br.com.fiap.lanchonete.gateway.repository.IPedidoRepository;
import br.com.fiap.lanchonete.gateway.repository.IProdutoRepository;

import java.util.stream.Collectors;

public class CriarPedidoUseCase implements ICriarPedido {

    private final IPedidoRepository pedidoRepository;
    private final IClienteRepository clienteRepository;
    private final IProdutoRepository produtoRepository;

    public CriarPedidoUseCase(IPedidoRepository repository, IClienteRepository clienteRepository, IProdutoRepository produtoRepository) {
        this.pedidoRepository = repository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
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
}