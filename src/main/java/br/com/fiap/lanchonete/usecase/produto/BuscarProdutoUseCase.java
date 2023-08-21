package br.com.fiap.lanchonete.usecase.produto;

import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.models.Produto;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class BuscarProdutoUseCase implements IBuscarProduto {

    private final ProdutoRepositoryPort repository;

    public BuscarProdutoUseCase(ProdutoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<ProdutoResponse> buscarTodos() {
        final var produtos = this.repository.buscarTodos();
        return produtos.stream().map(Produto::toProdutoResponse).collect(Collectors.toList());
    }

    @Override
    public List<ProdutoResponse> buscarPorCategoria(Integer id) {
        final var produtos = this.repository.buscarPorCategoria(id);
        return produtos.stream().map(Produto::toProdutoResponse).collect(Collectors.toList());
    }

}
