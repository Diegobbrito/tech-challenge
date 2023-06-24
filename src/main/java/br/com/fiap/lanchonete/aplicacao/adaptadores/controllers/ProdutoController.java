package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class ProdutoController {

    private final ProdutoServicePort service;
    public ProdutoController(ProdutoServicePort service) {
        this.service = service;
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoResponse>> listarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<List<ProdutoResponse>> listarPorCategoria(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarPorCategoria(id));
    }

    @PostMapping("/produtos")
    public ResponseEntity<Void> criar(@RequestBody ProdutoRequest request){
        service.criar(request);
        return new ResponseEntity(CREATED);
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Void> editar(@PathVariable Integer id, @RequestBody ProdutoRequest request){
        service.atualizar(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        service.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
