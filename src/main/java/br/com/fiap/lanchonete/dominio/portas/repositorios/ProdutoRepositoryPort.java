package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositoryPort {
    List<Produto> buscarTodos();
    void salvar(Produto produto);

    List<Produto> buscarPorCategoria(Integer id);

    Optional<ProdutoEntity> buscarPorId(Integer id);
}
