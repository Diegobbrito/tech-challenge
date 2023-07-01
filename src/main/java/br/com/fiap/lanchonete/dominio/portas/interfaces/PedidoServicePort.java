package br.com.fiap.lanchonete.dominio.portas.interfaces;

import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.PedidoResponse;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;

import java.util.List;

public interface PedidoServicePort {
    List<PedidoResponse> buscarTodos();
    void criar(ProdutoRequest produto);
}
