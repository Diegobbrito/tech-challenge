package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringCategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
    Optional<CategoriaEntity> findById(Integer id);
}
