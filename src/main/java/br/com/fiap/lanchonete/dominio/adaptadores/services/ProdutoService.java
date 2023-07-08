package br.com.fiap.lanchonete.dominio.adaptadores.services;
import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.models.Categoria;
import br.com.fiap.lanchonete.dominio.models.Produto;
import br.com.fiap.lanchonete.dominio.enumerator.CategoriaEnum;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoService implements ProdutoServicePort {

    private final ProdutoRepositoryPort repository;

    public ProdutoService(ProdutoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<ProdutoResponse> buscarTodos() {
        final var produtos = this.repository.buscarTodos();
        return produtos.stream().map(Produto::toProdutoResponse).collect(Collectors.toList());
    }

    @Override
    public ProdutoResponse criar(ProdutoRequest request) {
        final var checkCategoria = CategoriaEnum.from(request.getCategoriaId());
        if(checkCategoria == null){
            throw new IllegalArgumentException("Categoria Invalida");
        }
        final var produto = new Produto(request.getNome(), request.getDescricao(), request.getValor(), request.getImagemUrl(), new Categoria(request.getCategoriaId()));
        final var entity = this.repository.salvar(produto);
        return Produto.toProdutoResponse(entity);
    }

    @Override
    public List<ProdutoResponse> buscarPorCategoria(Integer id) {
        final var produtos = this.repository.buscarPorCategoria(id);
        return produtos.stream().map(Produto::toProdutoResponse).collect(Collectors.toList());
    }

    @Override
    public void excluirProduto(Integer id) {
        final var produto = this.repository.buscarPorId(id);
        if(produto.isEmpty()){
            throw new IllegalArgumentException("Produto não encontrado para exclusão");
        }
        repository.excluir(id);

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
}
