package br.com.fiap.lanchonete.core.usecase.produto;

import br.com.fiap.lanchonete.api.dto.request.ProdutoRequest;
import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;

public interface ICriarProduto {
    ProdutoResponse criar(ProdutoRequest produto);
}
