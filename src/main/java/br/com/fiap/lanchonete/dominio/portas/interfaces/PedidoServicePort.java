package br.com.fiap.lanchonete.dominio.portas.interfaces;

import br.com.fiap.lanchonete.dominio.dtos.request.PagamentoRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.PedidoRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.PedidoStatusRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.PedidoResponse;

import java.util.List;

public interface PedidoServicePort {
    List<PedidoResponse> buscarTodos();
    PedidoResponse criar(PedidoRequest produto);

    PedidoResponse pagar(Integer pedidoId, PagamentoRequest request);

    PedidoResponse atualizar(Integer pedidoId, PedidoStatusRequest request);
}
