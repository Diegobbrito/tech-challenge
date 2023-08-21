package br.com.fiap.lanchonete.usecase.produto;

import br.com.fiap.lanchonete.api.dto.request.ProdutoRequest;
import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.enumerator.CategoriaEnum;
import br.com.fiap.lanchonete.dominio.models.Categoria;
import br.com.fiap.lanchonete.dominio.models.Produto;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoRepositoryPort;

public class CriarProdutoUseCase implements ICriarProduto {

    private final ProdutoRepositoryPort repository;

    public CriarProdutoUseCase(ProdutoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoResponse criar(ProdutoRequest request) {
        final var checkCategoria = CategoriaEnum.from(request.getCategoriaId());
        if(checkCategoria == null){
            throw new IllegalArgumentException("Categoria Invalida");
        }
        final var produto = new Produto(request.getNome(), request.getDescricao(), request.getValor(), request.getImagemUrl(), new Categoria(request.getCategoriaId(), null,null));
        final var entity = this.repository.salvar(produto);
        return Produto.toProdutoResponse(entity);
    }
}
