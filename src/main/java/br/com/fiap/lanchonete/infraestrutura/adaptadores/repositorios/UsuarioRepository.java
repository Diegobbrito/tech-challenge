package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioRepository implements UsuarioRepositoryPort {

    private final SpringUsuarioRepository repository;

    public UsuarioRepository(SpringUsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<UsuarioEntity> buscarUsuario(String usuario) {
        return repository.findByNome(usuario);
    }
}
