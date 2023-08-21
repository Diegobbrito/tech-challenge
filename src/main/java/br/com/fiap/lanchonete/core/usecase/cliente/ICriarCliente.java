package br.com.fiap.lanchonete.core.usecase.cliente;

import br.com.fiap.lanchonete.api.dto.request.ClienteRequest;
import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;

public interface ICriarCliente {
    ClienteResponse criar(ClienteRequest produto);
}
