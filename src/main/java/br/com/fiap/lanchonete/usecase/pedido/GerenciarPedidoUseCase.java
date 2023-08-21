package br.com.fiap.lanchonete.usecase.pedido;

import br.com.fiap.lanchonete.api.dto.request.PagamentoRequest;
import br.com.fiap.lanchonete.api.dto.request.PedidoStatusRequest;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.dominio.enumerator.StatusEnum;
import br.com.fiap.lanchonete.dominio.models.Pedido;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PagamentoDataProviderPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.PedidoRepositoryPort;

public class GerenciarPedidoUseCase implements IGerenciarPedido {

    private final PedidoRepositoryPort pedidoRepository;
    private final PagamentoDataProviderPort pagamentoDataProvider;

    public GerenciarPedidoUseCase(PedidoRepositoryPort repository, PagamentoDataProviderPort pagamentoDataProvider) {
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
