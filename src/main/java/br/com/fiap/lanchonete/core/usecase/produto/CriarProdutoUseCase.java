package br.com.fiap.lanchonete.core.usecase.produto;

import br.com.fiap.lanchonete.api.dto.request.ProdutoRequest;
import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;
import br.com.fiap.lanchonete.core.enumerator.CategoriaEnum;
import br.com.fiap.lanchonete.core.entity.Categoria;
import br.com.fiap.lanchonete.core.entity.Produto;
import br.com.fiap.lanchonete.gateway.repository.IProdutoRepository;

public class CriarProdutoUseCase implements ICriarProduto {

    private final IProdutoRepository repository;

    public CriarProdutoUseCase(IProdutoRepository repository) {
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
