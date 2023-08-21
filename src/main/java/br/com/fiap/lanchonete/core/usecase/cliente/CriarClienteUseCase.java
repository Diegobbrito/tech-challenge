package br.com.fiap.lanchonete.core.usecase.cliente;
import br.com.fiap.lanchonete.api.dto.request.ClienteRequest;
import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;
import br.com.fiap.lanchonete.core.entity.Cliente;
import br.com.fiap.lanchonete.gateway.repository.IClienteRepository;

public class CriarClienteUseCase implements ICriarCliente {

    private final IClienteRepository reporitory;

    public CriarClienteUseCase(IClienteRepository reporitory) {
        this.reporitory = reporitory;
    }

    @Override
    public ClienteResponse criar(ClienteRequest request) {
        final var cliente = new Cliente(request.getCpf(), request.getNome(), request.getEmail());
        return new ClienteResponse(this.reporitory.salvar(cliente));
    }
}