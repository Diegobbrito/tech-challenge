package br.com.fiap.lanchonete.dominio.adaptadores.services;
import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepositoryPort repository;

    @Override
    public UserDetails loadUserByUsername(String usuario){
        final var usuarioOptional = repository.buscarUsuario(usuario);
        return usuarioOptional
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
