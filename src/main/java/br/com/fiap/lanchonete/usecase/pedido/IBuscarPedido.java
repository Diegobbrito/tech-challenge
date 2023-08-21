package br.com.fiap.lanchonete.usecase.pedido;

import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;

import java.util.List;

public interface IBuscarPedido {
    List<PedidoResponse> buscarTodos();
}
