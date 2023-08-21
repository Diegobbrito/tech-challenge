package br.com.fiap.lanchonete.gateway.repository;

import br.com.fiap.lanchonete.gateway.usuario.UsuarioEntity;

import java.util.Optional;

public interface IUsuarioRepository {
    Optional<UsuarioEntity> buscarUsuario(String usuario);
}
