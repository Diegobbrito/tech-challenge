package br.com.fiap.lanchonete.infraestrutura.configuracao;

import br.com.fiap.lanchonete.dominio.adaptadores.services.CategoriaService;
import br.com.fiap.lanchonete.dominio.adaptadores.services.ProdutoService;
import br.com.fiap.lanchonete.dominio.adaptadores.services.UsuarioService;
import br.com.fiap.lanchonete.dominio.portas.interfaces.CategoriaServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.UsuarioServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.CategoriaRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigaracao {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort repository){
        return new ProdutoService(repository);
    }

    @Bean
    UsuarioServicePort usuarioService(UsuarioRepositoryPort repository){
        return new UsuarioService(repository);
    }

    @Bean
    CategoriaServicePort categoriaService(CategoriaRepositoryPort repository){
        return new CategoriaService(repository);
    }
}
