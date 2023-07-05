package br.com.fiap.lanchonete.dominio.adaptadores.services;
import br.com.fiap.lanchonete.dominio.dtos.request.ClienteRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ClienteResponse;
import br.com.fiap.lanchonete.dominio.models.Cliente;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ClienteServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ClienteRepositoryPort;

import java.util.List;

public class ClienteService implements ClienteServicePort {

    private final ClienteRepositoryPort reporitory;

    public ClienteService(ClienteRepositoryPort reporitory) {
        this.reporitory = reporitory;
    }

    @Override
    public List<ClienteResponse> buscarTodos() {
        final var clientes = this.reporitory.buscarTodos();
        return null;
    }

    @Override
    public void criar(ClienteRequest request) {
        final var cliente = new Cliente(request.getCpf(), request.getNome(), request.getEmail());
        this.reporitory.salvar(cliente);
    }

    @Override
    public ClienteResponse buscarClientePorCpf(String cpf) {
        final var cliente = this.reporitory.buscarClientePorCpf(cpf);

        return new ClienteResponse(cliente);
    }
}
