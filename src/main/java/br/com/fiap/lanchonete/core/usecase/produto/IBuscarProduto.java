package br.com.fiap.lanchonete.core.usecase.produto;

import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;

import java.util.List;

public interface IBuscarProduto {
    List<ProdutoResponse> buscarTodos();
    List<ProdutoResponse> buscarPorCategoria(Integer id);
}
