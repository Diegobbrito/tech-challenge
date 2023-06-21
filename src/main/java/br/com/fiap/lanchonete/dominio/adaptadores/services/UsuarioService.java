package br.com.fiap.lanchonete.dominio.adaptadores.services;
import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.UsuarioRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.dtos.response.UsuarioResponse;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.dominio.entidades.Usuario;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.UsuarioServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoReporitoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioReporitoryPort;

import java.util.List;

public class UsuarioService implements UsuarioServicePort {

    private final UsuarioReporitoryPort reporitory;

    public UsuarioService(UsuarioReporitoryPort reporitory) {
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
