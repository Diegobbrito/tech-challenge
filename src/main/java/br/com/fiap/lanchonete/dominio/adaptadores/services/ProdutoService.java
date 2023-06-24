package br.com.fiap.lanchonete.dominio.adaptadores.services;
import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.entidades.Categoria;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.dominio.enumerator.CategoriaEnum;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoRepositoryPort;

import java.util.List;

public class ProdutoService implements ProdutoServicePort {

    private final ProdutoRepositoryPort reporitory;

    public ProdutoService(ProdutoRepositoryPort reporitory) {
        this.reporitory = reporitory;
    }

    @Override
    public List<ProdutoResponse> buscarTodos() {
        final var produtos = this.reporitory.buscarTodos();
        return null;
    }

    @Override
    public void criar(ProdutoRequest request) {
        final var categoriaId = request.getCategoriaId();

        final var checkCategoria = CategoriaEnum.from(categoriaId);

        if(checkCategoria == null){
            throw new IllegalArgumentException("Categoria Invalida");
        }



        final var produto = new Produto(request.getNome(), request.getDescricao(), request.getValor(), request.getImagemUrl(), new Categoria(request.getCategoriaId()));
        this.reporitory.salvar(produto);
    }
}
