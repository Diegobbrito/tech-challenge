package br.com.fiap.lanchonete.core.usecase.produto;

import br.com.fiap.lanchonete.api.adapter.ProdutoAdapter;
import br.com.fiap.lanchonete.api.dto.request.ProdutoRequest;
import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;
import br.com.fiap.lanchonete.config.UseCase;
import br.com.fiap.lanchonete.core.enumerator.CategoriaEnum;
import br.com.fiap.lanchonete.core.entity.Categoria;
import br.com.fiap.lanchonete.core.entity.Produto;
import br.com.fiap.lanchonete.gateway.repository.IProdutoRepository;
@UseCase
public class CriarProdutoUseCase implements ICriarProduto {

    private final IProdutoRepository repository;

    public CriarProdutoUseCase(IProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoResponse criar(ProdutoRequest request) {
        final var checkCategoria = CategoriaEnum.from(request.categoriaId());
        if(checkCategoria == null){
            throw new IllegalArgumentException("Categoria Invalida");
        }
        final var categoria = new Categoria(request.categoriaId());
        final var produto = new Produto(request.nome(), request.descricao(), request.valor(), categoria, request.imagemUrl());
        final var entity = this.repository.salvar(produto);
        return ProdutoAdapter.toResponse(entity);
    }
}
