package br.com.fiap.lanchonete.core.usecase.pedido;

import br.com.fiap.lanchonete.api.adapter.PedidoAdapter;
import br.com.fiap.lanchonete.api.dto.request.PagamentoRequest;
import br.com.fiap.lanchonete.api.dto.request.PedidoStatusRequest;
import br.com.fiap.lanchonete.api.dto.response.PagamentoStatusResponse;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.config.UseCase;
import br.com.fiap.lanchonete.core.enumerator.StatusEnum;
import br.com.fiap.lanchonete.core.exception.PedidoStatusException;
import br.com.fiap.lanchonete.gateway.dataprovider.IPagamentoDataProvider;
import br.com.fiap.lanchonete.gateway.repository.IPedidoRepository;
@UseCase
public class GerenciarPedidoUseCase implements IGerenciarPedido {

    private final IPedidoRepository pedidoRepository;
    private final IPagamentoDataProvider pagamentoDataProvider;

    public GerenciarPedidoUseCase(IPedidoRepository repository, IPagamentoDataProvider pagamentoDataProvider) {
        this.pedidoRepository = repository;
        this.pagamentoDataProvider = pagamentoDataProvider;
    }

    @Override
    public PedidoResponse validaPagamento(Integer pedidoId, PagamentoRequest request) {
        final var pedido = pedidoRepository.buscarPorId(pedidoId);
        final var checkPagamento = pagamentoDataProvider.validaPagamento(request.data().id());

        if(checkPagamento){
            pedido.setStatus(StatusEnum.RECEBIDO);
        }

        final var entity = pedidoRepository.atualizar(pedido);
        return PedidoAdapter.toResponseUpdate(entity);
    }

    @Override
    public PedidoResponse atualizar(Integer pedidoId, PedidoStatusRequest request) {
        final var pedido = pedidoRepository.buscarPorId(pedidoId);
        if(pedido.getStatus().getId().equals(request.statusId()))
            throw new PedidoStatusException("Pedido já está no status: " + pedido.getStatus().getTipo());
        pedido.setStatus(StatusEnum.from(request.statusId()));
        final var entity = pedidoRepository.atualizar(pedido);
        return PedidoAdapter.toResponseUpdate(entity);
    }

    @Override
    public PagamentoStatusResponse consultarStatusDePagamento(Integer pedidoId) {
        final var pedido = pedidoRepository.buscarPorId(pedidoId);
        if(pedido.getStatus().getId().equals(StatusEnum.PAGAMENTOPENDENTE.getId()))
            return PedidoAdapter.toPedidoStatus("Pagamento Pendente");
        return PedidoAdapter.toPedidoStatus("Pago");
    }
}
