package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.UsuarioEntity;

import java.util.Optional;

public interface UsuarioRepositoryPort {
    Optional<UsuarioEntity> buscarUsuario(String usuario);
}
