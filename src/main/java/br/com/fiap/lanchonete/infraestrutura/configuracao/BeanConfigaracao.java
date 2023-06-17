package br.com.fiap.lanchonete.infraestrutura.configuracao;

import br.com.fiap.lanchonete.dominio.adaptadores.services.ProdutoService;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ProdutoReporitoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigaracao {

    @Bean
    ProdutoServicePort produtoService(ProdutoReporitoryPort repository){
        return new ProdutoService(repository);
    }
}
