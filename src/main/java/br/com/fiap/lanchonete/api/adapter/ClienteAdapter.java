package br.com.fiap.lanchonete.api.adapter;

import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;
import br.com.fiap.lanchonete.core.entity.Cliente;
import br.com.fiap.lanchonete.gateway.repository.cliente.ClienteEntity;

public class ClienteAdapter {

    public static ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getCpf().getValor(),
                cliente.getNome(),
                cliente.getEmail().getValor());
    }

    public static Cliente toCliente(ClienteEntity clienteEntity){
        final var cliente = new Cliente(clienteEntity.getCpf(), clienteEntity.getNome(), clienteEntity.getEmail());
        cliente.setId(clienteEntity.getId());
        return cliente;
    }
}
