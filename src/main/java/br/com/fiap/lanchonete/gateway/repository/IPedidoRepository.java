package br.com.fiap.lanchonete.gateway.repository;

import br.com.fiap.lanchonete.core.entity.Pedido;

import java.util.List;

public interface IPedidoRepository {
    List<Pedido> buscarTodos();
    Pedido salvar(Pedido pedido);
    Pedido atualizar(Pedido pedido);
    Pedido buscarPorId(Integer pedidoId);
}
