package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Pedido;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoRepositoryPort {
    List<Pedido> buscarTodos();
    void salvar(Pedido pedido);
}
