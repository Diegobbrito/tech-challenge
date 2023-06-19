package br.com.fiap.lanchonete.infraestrutura.configuracao;

import br.com.fiap.lanchonete.dominio.adaptadores.services.ProdutoService;
import br.com.fiap.lanchonete.dominio.adaptadores.services.UsuarioService;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.UsuarioServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoReporitoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioReporitoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigaracao {

    @Bean
    ProdutoServicePort produtoService(ProdutoReporitoryPort repository){
        return new ProdutoService(repository);
    }

    @Bean
    UsuarioServicePort usuarioService(UsuarioReporitoryPort repository){
        return new UsuarioService(repository);
    }
}
