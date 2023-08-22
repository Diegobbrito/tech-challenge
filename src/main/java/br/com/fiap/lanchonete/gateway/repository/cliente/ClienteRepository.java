package br.com.fiap.lanchonete.gateway.repository.cliente;

import br.com.fiap.lanchonete.core.entity.Cliente;
import br.com.fiap.lanchonete.gateway.repository.IClienteRepository;
import br.com.fiap.lanchonete.core.exception.ClienteInexistenteException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteRepository implements IClienteRepository {

    private final JpaClienteRepository repository;

    public ClienteRepository(JpaClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> buscarTodos() {
        final var clientes = repository.findAll();
        return null;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        final var entity = new ClienteEntity(cliente);
        final var entitySalva = repository.save(entity);
        return new Cliente(entitySalva);
    }


    @Override
    public Cliente buscarClientePorCpf(String cpf) {

        final var cliente = repository
                .findByCpf(cpf)
                .orElseThrow(() -> new ClienteInexistenteException("Cliente não entrado"));
        return new Cliente(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Integer id) {

        final var cliente = repository
                .findById(id)
                .orElseThrow(() -> new ClienteInexistenteException("Cliente não entrado"));
        return new Cliente(cliente);
    }
}
