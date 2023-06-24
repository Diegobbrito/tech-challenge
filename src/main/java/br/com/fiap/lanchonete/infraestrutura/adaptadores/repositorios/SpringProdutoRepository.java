package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
    List<ProdutoEntity> findAllByCategoriaId(Integer categoriaId);
}
