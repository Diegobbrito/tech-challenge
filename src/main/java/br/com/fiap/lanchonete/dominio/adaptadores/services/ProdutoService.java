package br.com.fiap.lanchonete.dominio.adaptadores.services;
import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
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
    public void criar(ProdutoRequest produtoRequest) {
        final var produto = new Produto();
        this.reporitory.salvar(produto);
    }
}
