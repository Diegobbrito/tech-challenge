package br.com.fiap.lanchonete.dominio.portas.interfaces;

import br.com.fiap.lanchonete.dominio.dtos.request.PedidoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.PedidoResponse;

import java.util.List;

public interface PedidoServicePort {
    List<PedidoResponse> buscarTodos();
    void criar(PedidoRequest produto);
}
