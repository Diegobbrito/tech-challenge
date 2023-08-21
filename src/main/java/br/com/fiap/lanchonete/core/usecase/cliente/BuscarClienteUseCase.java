package br.com.fiap.lanchonete.core.usecase.cliente;
import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;
import br.com.fiap.lanchonete.gateway.repository.IClienteRepository;

import java.util.List;

public class BuscarClienteUseCase implements IBuscarCliente {

    private final IClienteRepository reporitory;

    public BuscarClienteUseCase(IClienteRepository reporitory) {
        this.reporitory = reporitory;
    }

    @Override
    public List<ClienteResponse> buscarTodos() {
        final var clientes = this.reporitory.buscarTodos();
        return null;
    }

    @Override
    public ClienteResponse buscarClientePorCpf(String cpf) {
        final var cpfFormatado = cpf.trim().replaceAll("\\.", "").replaceAll("-", "");
        final var cliente = this.reporitory.buscarClientePorCpf(cpfFormatado);

        return new ClienteResponse(cliente);
    }
}
