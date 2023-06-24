package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Usuario;
import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioRepository implements UsuarioRepositoryPort {

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
