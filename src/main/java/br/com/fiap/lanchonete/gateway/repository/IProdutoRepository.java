package br.com.fiap.lanchonete.gateway.repository;

import br.com.fiap.lanchonete.core.entity.Produto;
import br.com.fiap.lanchonete.gateway.repository.produto.ProdutoEntity;

import java.util.List;
import java.util.Optional;

public interface IProdutoRepository {
    List<Produto> buscarTodos();
    Produto salvar(Produto produto);

    List<Produto> buscarPorCategoria(Integer id);

    Optional<ProdutoEntity> buscarPorId(Integer id);

    void excluir(Integer id);

    List<Produto> buscarTodosPorIds(List<Integer> produtoIds);
}
