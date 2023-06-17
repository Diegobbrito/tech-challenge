package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Produto;

import java.util.List;

public interface ProdutoReporitoryPort {
    List<Produto> buscarTodos();
    void salvar(Produto produto);
}
