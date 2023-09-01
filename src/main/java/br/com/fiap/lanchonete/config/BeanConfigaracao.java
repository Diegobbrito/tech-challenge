package br.com.fiap.lanchonete.config;

import br.com.fiap.lanchonete.core.usecase.pedido.*;
import br.com.fiap.lanchonete.core.usecase.produto.*;
import br.com.fiap.lanchonete.core.usecase.categoria.BuscarCategoriaUseCase;
import br.com.fiap.lanchonete.core.usecase.categoria.IBuscarCategoria;
import br.com.fiap.lanchonete.core.usecase.cliente.BuscarClienteUseCase;
import br.com.fiap.lanchonete.core.usecase.cliente.CriarClienteUseCase;
import br.com.fiap.lanchonete.core.usecase.cliente.IBuscarCliente;
import br.com.fiap.lanchonete.core.usecase.cliente.ICriarCliente;
import br.com.fiap.lanchonete.gateway.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigaracao {

    @Bean
    IBuscarCategoria buscarCategoria(ICategoriaRepository repository){
        return new BuscarCategoriaUseCase(repository);
    }

    @Bean
    IBuscarCliente buscarCliente(IClienteRepository repository){
        return new BuscarClienteUseCase(repository);
    }

    @Bean
    ICriarCliente criarCliente(IClienteRepository repository){
        return new CriarClienteUseCase(repository);
    }

    @Bean
    IBuscarPedido buscarPedido(IPedidoRepository repository){
        return new BuscarPedidoUseCase(repository);
    }

    @Bean
    ICriarPedido criarPedido(IPedidoRepository repository, IClienteRepository clienteRepository, IProdutoRepository produtoRepository){
        return new CriarPedidoUseCase(repository, clienteRepository, produtoRepository);
    }

    @Bean
    IGerenciarPedido gerenciarPedido(IPedidoRepository repository, IPagamentoDataProvider pagamentoDataProvider){
        return new GerenciarPedidoUseCase(repository, pagamentoDataProvider);
    }

    @Bean
    IBuscarProduto buscarProduto(IProdutoRepository repository){
        return new BuscarProdutoUseCase(repository);
    }

    @Bean
    ICriarProduto criarProduto(IProdutoRepository repository){
        return new CriarProdutoUseCase(repository);
    }

    @Bean
    IGerenciarProduto gerenciarProduto(IProdutoRepository repository){
        return new GerenciarProdutoUseCase(repository);
    }



}
