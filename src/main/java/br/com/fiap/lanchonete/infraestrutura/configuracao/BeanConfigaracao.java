package br.com.fiap.lanchonete.infraestrutura.configuracao;

import br.com.fiap.lanchonete.dominio.adaptadores.services.CategoriaService;
import br.com.fiap.lanchonete.dominio.adaptadores.services.PedidoService;
import br.com.fiap.lanchonete.dominio.adaptadores.services.ProdutoService;
import br.com.fiap.lanchonete.dominio.adaptadores.services.ClienteService;
import br.com.fiap.lanchonete.dominio.portas.interfaces.CategoriaServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ClienteServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigaracao {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort repository){
        return new ProdutoService(repository);
    }
    @Bean
    ClienteServicePort clienteService(ClienteRepositoryPort repository){
        return new ClienteService(repository);
    }
    @Bean
    CategoriaServicePort categoriaService(CategoriaRepositoryPort repository){
        return new CategoriaService(repository);
    }
    @Bean
    PedidoServicePort pedidoService(PedidoRepositoryPort repository, ClienteRepositoryPort clienteRepository, ProdutoRepositoryPort produtoRepository, PagamentoDataProviderPort pagamentoDataProvider){
        return new PedidoService(repository, clienteRepository, produtoRepository, pagamentoDataProvider);
    }
}
