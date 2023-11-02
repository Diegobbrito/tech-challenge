package br.com.fiap.lanchonete.core.usecase.cliente;

import br.com.fiap.lanchonete.api.adapter.ClienteAdapter;
import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;
import br.com.fiap.lanchonete.config.UseCase;
import br.com.fiap.lanchonete.gateway.repository.IClienteRepository;

import java.util.List;
@UseCase
public class BuscarClienteUseCase implements IBuscarCliente {

    private final IClienteRepository repository;

    public BuscarClienteUseCase(IClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClienteResponse> buscarTodos() {
        final var clientes = this.repository.buscarTodos();
        return null;
    }

    @Override
    public ClienteResponse buscarClientePorCpf(String cpf) {
        final var cpfFormatado = cpf.trim().replaceAll("\\.", "").replaceAll("-", "");
        final var cliente = this.repository.buscarClientePorCpf(cpfFormatado);

        return ClienteAdapter.toResponse(cliente);
    }
}
