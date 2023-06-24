package br.com.fiap.lanchonete.dominio.adaptadores.services;
import br.com.fiap.lanchonete.dominio.dtos.request.UsuarioRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.UsuarioResponse;
import br.com.fiap.lanchonete.dominio.entidades.Usuario;
import br.com.fiap.lanchonete.dominio.portas.interfaces.UsuarioServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioRepositoryPort;

import java.util.List;

public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort reporitory;

    public UsuarioService(UsuarioRepositoryPort reporitory) {
        this.reporitory = reporitory;
    }

    @Override
    public List<UsuarioResponse> buscarTodos() {
        final var usuarios = this.reporitory.buscarTodos();
        return null;
    }

    @Override
    public void criar(UsuarioRequest request) {
        final var usuario = new Usuario();
        this.reporitory.salvar(usuario);
    }
}
