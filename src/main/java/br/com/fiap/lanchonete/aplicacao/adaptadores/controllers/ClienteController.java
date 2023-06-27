package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import br.com.fiap.lanchonete.dominio.dtos.request.ClienteRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ClienteResponse;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ClienteServicePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    private final ClienteServicePort service;
    public ClienteController(ClienteServicePort service) {
        this.service = service;
    }

    @GetMapping("/clientes/{cpf}")
    public ResponseEntity<ClienteResponse> buscaClientePorCpf(@PathVariable String cpf){

        return ResponseEntity.ok(service.buscarClientePorCpf(cpf));
    }

    @PostMapping("/clientes")
    public void cadastrar(@RequestBody @Valid ClienteRequest request){
        service.criar(request);
    }
}
