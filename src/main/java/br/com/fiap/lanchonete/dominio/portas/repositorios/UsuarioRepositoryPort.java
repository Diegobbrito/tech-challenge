package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Usuario;

import java.util.List;

public interface UsuarioRepositoryPort {
    List<Usuario> buscarTodos();
    void salvar(Usuario produto);
}
