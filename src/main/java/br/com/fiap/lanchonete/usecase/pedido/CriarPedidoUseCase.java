package br.com.fiap.lanchonete.usecase.pedido;

import br.com.fiap.lanchonete.api.dto.request.PedidoRequest;
import br.com.fiap.lanchonete.api.dto.request.ProdutoSelecionadoRequest;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.dominio.enumerator.StatusEnum;
import br.com.fiap.lanchonete.dominio.models.Cliente;
import br.com.fiap.lanchonete.dominio.models.Pedido;
import br.com.fiap.lanchonete.dominio.models.Status;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ClienteRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PedidoRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoRepositoryPort;

import java.util.stream.Collectors;

public class CriarPedidoUseCase implements ICriarPedido {

    private final PedidoRepositoryPort pedidoRepository;
    private final ClienteRepositoryPort clienteRepository;
    private final ProdutoRepositoryPort produtoRepository;

    public CriarPedidoUseCase(PedidoRepositoryPort repository, ClienteRepositoryPort clienteRepository, ProdutoRepositoryPort produtoRepository) {
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
