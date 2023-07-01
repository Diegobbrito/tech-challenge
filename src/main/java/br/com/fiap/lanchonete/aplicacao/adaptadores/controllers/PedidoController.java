package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    private final PedidoServicePort service;
    public PedidoController(PedidoServicePort service) {
        this.service = service;
    }

    @GetMapping("/pedidos")
    public void listarTodos(){
        service.buscarTodos();
    }
}
