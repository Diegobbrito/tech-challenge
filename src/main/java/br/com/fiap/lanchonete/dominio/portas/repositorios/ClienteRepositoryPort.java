package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Cliente;

import java.util.List;

public interface ClienteRepositoryPort {
    List<Cliente> buscarTodos();
    void salvar(Cliente produto);

    Cliente buscarClientePorCpf(String cpf);

    Cliente buscarClientePorId(Integer id);
}
