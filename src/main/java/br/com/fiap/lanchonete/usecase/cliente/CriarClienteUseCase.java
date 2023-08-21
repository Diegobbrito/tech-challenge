package br.com.fiap.lanchonete.usecase.cliente;
import br.com.fiap.lanchonete.api.dto.request.ClienteRequest;
import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;
import br.com.fiap.lanchonete.dominio.models.Cliente;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ClienteRepositoryPort;

public class CriarClienteUseCase implements ICriarCliente {

    private final ClienteRepositoryPort reporitory;

    public CriarClienteUseCase(ClienteRepositoryPort reporitory) {
        this.reporitory = reporitory;
    }

    @Override
    public ClienteResponse criar(ClienteRequest request) {
        final var cliente = new Cliente(request.getCpf(), request.getNome(), request.getEmail());
        return new ClienteResponse(this.reporitory.salvar(cliente));
    }
}
