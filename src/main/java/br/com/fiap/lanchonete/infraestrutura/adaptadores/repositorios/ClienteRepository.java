package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Cliente;
import br.com.fiap.lanchonete.dominio.portas.repositorios.ClienteRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ClienteEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.exceptions.ClienteInexistenteException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteRepository implements ClienteRepositoryPort {

    private final SpringClienteRepository repository;

    public ClienteRepository(SpringClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> buscarTodos() {
        final var clientes = repository.findAll();
        return null;
    }

    @Override
    public void salvar(Cliente cliente) {
        final var entity = new ClienteEntity(cliente);
        repository.save(entity);
    }


    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        final var cpfFormatado = cpf.trim().replaceAll("\\.", "").replaceAll("-", "");
        final var cliente = repository
                .findByCpf(cpfFormatado)
                .orElseThrow(() -> new ClienteInexistenteException("Cliente não entrado"));
        return new Cliente(cliente);
    }
}
