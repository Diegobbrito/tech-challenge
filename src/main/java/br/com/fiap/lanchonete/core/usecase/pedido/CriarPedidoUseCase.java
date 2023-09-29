package br.com.fiap.lanchonete.core.usecase.pedido;

import br.com.fiap.lanchonete.api.adapter.PedidoAdapter;
import br.com.fiap.lanchonete.api.dto.request.PedidoRequest;
import br.com.fiap.lanchonete.api.dto.request.ProdutoSelecionadoRequest;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.config.UseCase;
import br.com.fiap.lanchonete.core.entity.Cliente;
import br.com.fiap.lanchonete.core.entity.Pedido;
import br.com.fiap.lanchonete.core.entity.Status;
import br.com.fiap.lanchonete.core.enumerator.StatusEnum;
import br.com.fiap.lanchonete.gateway.dataprovider.IPagamentoDataProvider;
import br.com.fiap.lanchonete.gateway.repository.IClienteRepository;
import br.com.fiap.lanchonete.gateway.repository.IPedidoRepository;
import br.com.fiap.lanchonete.gateway.repository.IProdutoRepository;

import java.util.stream.Collectors;
@UseCase
public class CriarPedidoUseCase implements ICriarPedido {

    private final IPedidoRepository pedidoRepository;
    private final IClienteRepository clienteRepository;
    private final IProdutoRepository produtoRepository;
    private final IPagamentoDataProvider pagamentoDataProvider;

    public CriarPedidoUseCase(IPedidoRepository repository, IClienteRepository clienteRepository, IProdutoRepository produtoRepository, IPagamentoDataProvider pagamentoDataProvider) {
        this.pedidoRepository = repository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.pagamentoDataProvider = pagamentoDataProvider;
    }

    @Override
    public PedidoResponse criar(PedidoRequest request) {
        Pedido pedido;

        final var ids = request.produtos().stream().map(ProdutoSelecionadoRequest::produtoId).collect(Collectors.toList());
        final var produtos = this.produtoRepository.buscarTodosPorIds(ids);

        final var status = new Status(StatusEnum.PAGAMENTOPENDENTE);
        Cliente cliente = null;
        if(request.cpf() != null && !request.cpf().isBlank()){
            final var cpfFormatado = request.cpf().trim().replaceAll("\\.", "").replaceAll("-", "");
            cliente = this.clienteRepository.buscarClientePorCpf(cpfFormatado);
        }
        pedido = PedidoAdapter.toPedido(request, cliente, produtos, status);

        final var entity = pedidoRepository.salvar(pedido);

        final var qrData = this.pagamentoDataProvider.criarPagamento(entity);

        return PedidoAdapter.toResponse(entity, qrData);
    }
}
