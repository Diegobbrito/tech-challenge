package br.com.fiap.lanchonete.configuracao;

import br.com.fiap.lanchonete.dominio.portas.repositorios.*;
import br.com.fiap.lanchonete.usecase.categoria.BuscarCategoriaUseCase;
import br.com.fiap.lanchonete.usecase.categoria.IBuscarCategoria;
import br.com.fiap.lanchonete.usecase.cliente.BuscarClienteUseCase;
import br.com.fiap.lanchonete.usecase.cliente.CriarClienteUseCase;
import br.com.fiap.lanchonete.usecase.cliente.IBuscarCliente;
import br.com.fiap.lanchonete.usecase.cliente.ICriarCliente;
import br.com.fiap.lanchonete.usecase.pedido.*;
import br.com.fiap.lanchonete.usecase.produto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigaracao {

    @Bean
    IBuscarCategoria buscarCategoriaUseCase(CategoriaRepositoryPort repository){
        return new BuscarCategoriaUseCase(repository);
    }

    @Bean
    IBuscarCliente buscarClienteUseCase(ClienteRepositoryPort repository){
        return new BuscarClienteUseCase(repository);
    }

    @Bean
    ICriarCliente criarClienteUseCase(ClienteRepositoryPort repository){
        return new CriarClienteUseCase(repository);
    }

    @Bean
    IBuscarPedido buscarPedido(PedidoRepositoryPort repository){
        return new BuscarPedidoUseCase(repository);
    }

    @Bean
    ICriarPedido criarPedido(PedidoRepositoryPort repository, ClienteRepositoryPort clienteRepository, ProdutoRepositoryPort produtoRepository){
        return new CriarPedidoUseCase(repository, clienteRepository, produtoRepository);
    }

    @Bean
    IGerenciarPedido gerenciarPedido(PedidoRepositoryPort repository, PagamentoDataProviderPort pagamentoDataProvider){
        return new GerenciarPedidoUseCase(repository, pagamentoDataProvider);
    }

    @Bean
    IBuscarProduto buscarProdutoUseCase(ProdutoRepositoryPort repository){
        return new BuscarProdutoUseCase(repository);
    }

    @Bean
    ICriarProduto criarProduto(ProdutoRepositoryPort repository){
        return new CriarProdutoUseCase(repository);
    }

    @Bean
    IGerenciarProduto gerenciarProduto(ProdutoRepositoryPort repository){
        return new GerenciarProdutoUseCase(repository);
    }



}
