package br.com.fiap.lanchonete.gateway.repository.usuario;

import br.com.fiap.lanchonete.gateway.repository.IUsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioRepository implements IUsuarioRepository {

    private final JpaUsuarioRepository repository;

    public UsuarioRepository(JpaUsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<UsuarioEntity> buscarUsuario(String usuario) {
        return repository.findByNome(usuario);
    }
}
