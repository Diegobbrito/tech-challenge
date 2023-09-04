package br.com.fiap.lanchonete.api.controllers;

import br.com.fiap.lanchonete.api.dto.request.ClienteRequest;
import br.com.fiap.lanchonete.api.dto.response.ClienteResponse;
import br.com.fiap.lanchonete.core.usecase.cliente.IBuscarCliente;
import br.com.fiap.lanchonete.core.usecase.cliente.ICriarCliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Clientes", description = "Controle de clientes")
@RestController
public class ClienteController {

    private final IBuscarCliente buscarClienteUseCase;
    private final ICriarCliente criarClienteUseCase;
    public ClienteController(IBuscarCliente buscarClienteUseCase, ICriarCliente criarClienteUseCase) {
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.criarClienteUseCase = criarClienteUseCase;
    }

    @Operation(summary = "Busca de cliente por cpf")
    @GetMapping("/clientes/{cpf}")
    public ResponseEntity<ClienteResponse> buscaClientePorCpf(@Parameter(example = "055.069.020-42") @PathVariable String cpf){
        return ResponseEntity.ok(buscarClienteUseCase.buscarClientePorCpf(cpf));
    }

    @Operation(summary = "Criação de cliente")
    @PostMapping("/clientes")
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody ClienteRequest request){
        return new ResponseEntity<>(criarClienteUseCase.criar(request), HttpStatus.CREATED);
    }
}
