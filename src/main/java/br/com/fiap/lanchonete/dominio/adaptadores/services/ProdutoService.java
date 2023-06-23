package br.com.fiap.lanchonete.dominio.adaptadores.services;
import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.dominio.enumerator.Categoria;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoReporitoryPort;

import java.util.List;

public class ProdutoService implements ProdutoServicePort {

    private final ProdutoReporitoryPort reporitory;

    public ProdutoService(ProdutoReporitoryPort reporitory) {
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

        final var categoria = Categoria.from(categoriaId);

        final var produto = new Produto(request.getNome(), request.getDescricao(), request.getValor(), request.getImagemUrl(), categoria);
        this.reporitory.salvar(produto);
    }
}
