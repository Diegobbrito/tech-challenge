package br.com.fiap.lanchonete.dominio.portas.interfaces;

import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;

import java.util.List;

public interface ProdutoServicePort {
    List<ProdutoResponse> buscarTodos();
    ProdutoResponse criar(ProdutoRequest produto);

    List<ProdutoResponse> buscarPorCategoria(Integer id);

    void excluirProduto(Integer id);

    ProdutoResponse atualizar(Integer id, ProdutoRequest request);
}
