package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.dominio.models.Cliente;

import java.util.List;

public interface ClienteRepositoryPort {
    List<Cliente> buscarTodos();
    Cliente salvar(Cliente produto);

    Cliente buscarClientePorCpf(String cpf);

    Cliente buscarClientePorId(Integer id);
}
