package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import br.com.fiap.lanchonete.dominio.dtos.request.PedidoRequest;
import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Pedidos", description = "Controle de pedidos")
@RestController
public class PedidoController {

    private final PedidoServicePort service;
    public PedidoController(PedidoServicePort service) {
        this.service = service;
    }

    @Operation(summary = "Listagem de todos os pedidos do dia")
    @GetMapping("/pedidos")
    public void listarTodos(){
        service.buscarTodos();
    }

    @Operation(summary = "Criação de  pedidos")
    @GetMapping("/produtos")
    public void criar(PedidoRequest request){
        service.criar(request);
    }
}
