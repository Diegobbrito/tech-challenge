package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.dominio.enumerator.StatusEnum;
import br.com.fiap.lanchonete.dominio.models.Pedido;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.PedidoEntity;

import java.util.List;

public interface PedidoRepositoryPort {
    List<Pedido> buscarTodos();
    Pedido salvar(Pedido pedido);

    Pedido buscarPorId(Integer pedidoId);
}
