package br.com.fiap.lanchonete.usecase.cliente;
import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ClienteRepositoryPort;

import java.util.List;

public class BuscarClienteUseCase implements IBuscarCliente {

    private final ClienteRepositoryPort reporitory;

    public BuscarClienteUseCase(ClienteRepositoryPort reporitory) {
        this.reporitory = reporitory;
    }

    @Override
    public List<ClienteResponse> buscarTodos() {
        final var clientes = this.reporitory.buscarTodos();
        return null;
    }

    @Override
    public ClienteResponse buscarClientePorCpf(String cpf) {
        final var cliente = this.reporitory.buscarClientePorCpf(cpf);

        return new ClienteResponse(cliente);
    }
}
