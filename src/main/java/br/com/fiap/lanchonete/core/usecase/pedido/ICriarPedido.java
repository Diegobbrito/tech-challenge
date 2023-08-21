package br.com.fiap.lanchonete.core.usecase.pedido;

import br.com.fiap.lanchonete.api.dto.request.PedidoRequest;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;

public interface ICriarPedido {
    PedidoResponse criar(PedidoRequest produto);
}
