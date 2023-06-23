package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringCategoriaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findById(Long id);
}
