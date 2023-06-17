package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoReporitoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoRepository implements ProdutoReporitoryPort {

    private final SpringProdutoRepository repository;

    public ProdutoRepository(SpringProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Produto> buscarTodos() {
        final var produtos = repository.findAll();
        return produtos.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
    }

    @Override
    public void salvar(Produto produto) {
        final var entity = new ProdutoEntity();
        repository.save(entity);
    }
}
