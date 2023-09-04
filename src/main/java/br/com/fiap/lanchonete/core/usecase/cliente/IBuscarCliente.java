package br.com.fiap.lanchonete.core.usecase.cliente;

import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;

import java.util.List;

public interface IBuscarCliente {
    List<ClienteResponse> buscarTodos();
    ClienteResponse buscarClientePorCpf(String cpf);
}
