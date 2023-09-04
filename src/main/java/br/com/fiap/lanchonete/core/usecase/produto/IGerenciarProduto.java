package br.com.fiap.lanchonete.core.usecase.produto;

import br.com.fiap.lanchonete.api.dto.request.ProdutoRequest;
import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;

public interface IGerenciarProduto {
    void excluirProduto(Integer id);

    ProdutoResponse atualizar(Integer id, ProdutoRequest request);
}
