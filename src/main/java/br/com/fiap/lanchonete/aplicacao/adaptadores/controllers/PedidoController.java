package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import br.com.fiap.lanchonete.dominio.dtos.request.PagamentoRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.PedidoRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.PedidoStatusRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.PedidoResponse;
import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pedidos", description = "Controle de pedidos")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoServicePort service;
    public PedidoController(PedidoServicePort service) {
        this.service = service;
    }

    @Operation(summary = "Listagem de todos os pedidos")
    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @Operation(summary = "Consulta status de pagamento um pedido")
    @GetMapping("/{pedidoId}")
    public ResponseEntity<PedidoResponse> detalheDePagamentoDoPedido(){
        return ResponseEntity.ok(service.consultarStatusDePagamento());
    }

    @Operation(summary = "Criação de  pedidos")
    @PostMapping
    public ResponseEntity<PedidoResponse> criar(@RequestBody PedidoRequest request){
        return new ResponseEntity<>(service.criar(request), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Pagamento do  pedido")
    @PostMapping("/{pedidoId}/pagamento")
    public ResponseEntity<PedidoResponse> pagamento(@Parameter(example = "1") @PathVariable Integer pedidoId, @RequestBody PagamentoRequest request){
        return new ResponseEntity<>(service.pagar(pedidoId, request), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Atualização do status do  pedido")
    @PatchMapping("/{pedidoId}/atualizar")
    public ResponseEntity<PedidoResponse> atualizar(@Parameter(example = "1") @PathVariable Integer pedidoId, @RequestBody PedidoStatusRequest request){
        return new ResponseEntity<>(service.atualizar(pedidoId, request), HttpStatus.CREATED) ;
    }
}
