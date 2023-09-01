package br.com.fiap.lanchonete.gateway.repository;

import br.com.fiap.lanchonete.core.entity.Cliente;

import java.util.List;

public interface IClienteRepository {
    List<Cliente> buscarTodos();
    Cliente salvar(Cliente produto);

    Cliente buscarClientePorCpf(String cpf);
}
