package br.com.fiap.lanchonete.dominio.portas.interfaces;

import br.com.fiap.lanchonete.dominio.dtos.request.ClienteRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ClienteResponse;

import java.util.List;

public interface ClienteServicePort {
    List<ClienteResponse> buscarTodos();
    ClienteResponse criar(ClienteRequest produto);

    ClienteResponse buscarClientePorCpf(String cpf);
}
