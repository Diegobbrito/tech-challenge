package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import br.com.fiap.lanchonete.dominio.dtos.request.PagamentoRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.PedidoRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.PedidoStatusRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.PedidoResponse;
import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pedidos", description = "Controle de pedidos")
@RestController
public class PedidoController {

    private final PedidoServicePort service;
    public PedidoController(PedidoServicePort service) {
        this.service = service;
    }

    @Operation(summary = "Listagem de todos os pedidos do dia")
    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoResponse>> listarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @Operation(summary = "Criação de  pedidos")
    @PostMapping("/pedidos")
    public ResponseEntity<PedidoResponse> criar(@RequestBody PedidoRequest request){
        return new ResponseEntity<>(service.criar(request), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Pagamento do  pedido")
    @PostMapping("/pedidos/{pedidoId}/pagamento")
    public ResponseEntity<PedidoResponse> pagamento(@PathVariable Integer pedidoId, @RequestBody PagamentoRequest request){
        return new ResponseEntity<>(service.pagar(pedidoId, request), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Atualização do status do  pedido")
    @PatchMapping("/pedidos/{pedidoId}/atualizar")
    public ResponseEntity<PedidoResponse> atualizar(@PathVariable Integer pedidoId, @RequestBody PedidoStatusRequest request){
        return new ResponseEntity<>(service.atualizar(pedidoId, request), HttpStatus.CREATED) ;
    }
}
