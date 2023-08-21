package br.com.fiap.lanchonete.usecase;

import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioRepositoryPort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepositoryPort repository;

    public UsuarioService(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario){
        final var usuarioOptional = repository.buscarUsuario(usuario);
        return usuarioOptional
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
