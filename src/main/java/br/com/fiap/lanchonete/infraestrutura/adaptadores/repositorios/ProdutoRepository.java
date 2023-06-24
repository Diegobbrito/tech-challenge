package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

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
        System.out.println(produto.getNome());
        System.out.println(produto.getValor());
        System.out.println(produto.getDescricao());
        final var entity = new ProdutoEntity(produto);
        System.out.println(entity.getNome());
        System.out.println(entity.getValor());
        System.out.println(entity.getDescricao());
        repository.save(entity);
    }
}
