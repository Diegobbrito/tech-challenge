package br.com.fiap.lanchonete.gateway.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
    List<ProdutoEntity> findAllByCategoriaId(Integer categoriaId);

    List<ProdutoEntity> findByIdIn(List<Integer> ids);
}
