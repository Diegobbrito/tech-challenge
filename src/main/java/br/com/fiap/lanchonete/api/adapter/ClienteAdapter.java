package br.com.fiap.lanchonete.api.adapter;

import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;
import br.com.fiap.lanchonete.core.entity.Cliente;

public class ClienteAdapter {

    public static ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getId(),
                cliente.getCpf().getValor(),
                cliente.getNome(),
                cliente.getEmail().getValor());
    }
}
