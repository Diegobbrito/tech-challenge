package br.com.fiap.lanchonete.core.usecase.cliente;
import br.com.fiap.lanchonete.api.adapter.ClienteAdapter;
import br.com.fiap.lanchonete.api.dto.request.ClienteRequest;
import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;
import br.com.fiap.lanchonete.core.entity.Cliente;
import br.com.fiap.lanchonete.gateway.repository.IClienteRepository;

public class CriarClienteUseCase implements ICriarCliente {

    private final IClienteRepository repository;

    public CriarClienteUseCase(IClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteResponse criar(ClienteRequest request) {
        final var cliente = new Cliente(request.getCpf(), request.getNome(), request.getEmail());
        return ClienteAdapter.toResponse(repository.salvar(cliente));
    }
}
