package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.dtos.response.UsuarioResponse;
import br.com.fiap.lanchonete.dominio.entidades.Produto;
import br.com.fiap.lanchonete.dominio.entidades.Usuario;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoReporitoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioReporitoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioRepository implements UsuarioReporitoryPort {

    private final SpringUsuarioRepository repository;

    public UsuarioRepository(SpringUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Usuario> buscarTodos() {
        final var produtos = repository.findAll();
        return null;
    }

    @Override
    public void salvar(Usuario usuario) {
        final var entity = new UsuarioEntity(usuario);
        repository.save(entity);
    }
}
