package br.com.fiap.lanchonete.core.usecase.produto;
import br.com.fiap.lanchonete.api.dto.request.ProdutoRequest;
import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;
import br.com.fiap.lanchonete.core.entity.Produto;
import br.com.fiap.lanchonete.gateway.repository.IProdutoRepository;

public class GerenciarProdutoUseCase implements IGerenciarProduto {

    private final IProdutoRepository repository;

    public GerenciarProdutoUseCase(IProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoResponse atualizar(Integer id, ProdutoRequest request) {
        final var produto = this.repository.buscarPorId(id);
        if(produto.isEmpty()){
            throw new IllegalArgumentException("Produto não encontrado para atualização");
        }

        final var entity = repository.salvar(produto.get().toProduto(request));

        return Produto.toProdutoResponse(entity);
    }

    @Override
    public void excluirProduto(Integer id) {
        final var produto = this.repository.buscarPorId(id);
        if(produto.isEmpty()){
            throw new IllegalArgumentException("Produto não encontrado para exclusão");
        }
        repository.excluir(id);

    }
}
