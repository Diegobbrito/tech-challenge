package br.com.fiap.lanchonete.core.usecase.pedido;

import br.com.fiap.lanchonete.api.adapter.PedidoAdapter;
import br.com.fiap.lanchonete.api.dto.request.PagamentoRequest;
import br.com.fiap.lanchonete.api.dto.request.PedidoStatusRequest;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.core.enumerator.StatusEnum;
import br.com.fiap.lanchonete.gateway.repository.IPagamentoDataProvider;
import br.com.fiap.lanchonete.gateway.repository.IPedidoRepository;

public class GerenciarPedidoUseCase implements IGerenciarPedido {

    private final IPedidoRepository pedidoRepository;
    private final IPagamentoDataProvider pagamentoDataProvider;

    public GerenciarPedidoUseCase(IPedidoRepository repository, IPagamentoDataProvider pagamentoDataProvider) {
        this.pedidoRepository = repository;
        this.pagamentoDataProvider = pagamentoDataProvider;
    }

    @Override
    public PedidoResponse pagar(Integer pedidoId, PagamentoRequest request) {
        final var pedido = pedidoRepository.buscarPorId(pedidoId);
        final var checkPagamento = this.pagamentoDataProvider.realizarPagamento(request.getHash());

        if(checkPagamento){
            pedido.setStatus(StatusEnum.RECEBIDO);
        }

        final var entity = pedidoRepository.salvar(pedido);
        return PedidoAdapter.toResponse(entity);
    }

    @Override
    public PedidoResponse atualizar(Integer pedidoId, PedidoStatusRequest request) {
        final var pedido = pedidoRepository.buscarPorId(pedidoId);
        pedido.setStatus(StatusEnum.from(request.getStatusId()));
        final var entity = pedidoRepository.salvar(pedido);
        return PedidoAdapter.toResponse(entity);
    }

    @Override
    public PedidoResponse consultarStatusDePagamento() {
        return null;
    }
}
