package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.dominio.entidades.Usuario;

import java.util.List;

public interface UsuarioReporitoryPort {
    List<Usuario> buscarTodos();
    void salvar(Usuario produto);
}
