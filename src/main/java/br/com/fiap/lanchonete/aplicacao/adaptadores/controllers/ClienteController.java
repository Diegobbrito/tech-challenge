package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import br.com.fiap.lanchonete.dominio.dtos.request.ClienteRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ClienteResponse;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ClienteServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Clientes", description = "Controle de clientes")
@RestController
public class ClienteController {

    private final ClienteServicePort service;
    public ClienteController(ClienteServicePort service) {
        this.service = service;
    }

    @Operation(summary = "Busca de cliente por cpf")
    @GetMapping("/clientes/{cpf}")
    public ResponseEntity<ClienteResponse> buscaClientePorCpf(@PathVariable String cpf){

        return ResponseEntity.ok(service.buscarClientePorCpf(cpf));
    }

    @Operation(summary = "Criação de cliente")
    @PostMapping("/clientes")
    public void cadastrar(@RequestBody @Valid ClienteRequest request){
        service.criar(request);
    }
}
