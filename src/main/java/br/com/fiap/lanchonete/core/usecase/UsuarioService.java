package br.com.fiap.lanchonete.core.usecase;

import br.com.fiap.lanchonete.gateway.repository.IUsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private final IUsuarioRepository repository;

    public UsuarioService(IUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario){
        final var usuarioOptional = repository.buscarUsuario(usuario);
        return usuarioOptional
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
