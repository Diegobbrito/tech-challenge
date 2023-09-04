package br.com.fiap.lanchonete.core.usecase.pedido;

import br.com.fiap.lanchonete.api.dto.request.PagamentoRequest;
import br.com.fiap.lanchonete.api.dto.request.PedidoStatusRequest;
import br.com.fiap.lanchonete.api.dto.response.PagamentoStatusResponse;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;

public interface IGerenciarPedido {

    PedidoResponse validaPagamento(Integer pedidoId, PagamentoRequest request);

    PedidoResponse atualizar(Integer pedidoId, PedidoStatusRequest request);

    PagamentoStatusResponse consultarStatusDePagamento(Integer pedidoId);
}
