package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class ProdutoController {

    private ProdutoServicePort service;
    public ProdutoController(ProdutoServicePort service) {
        this.service = service;
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoResponse>> listarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping("/produtos")
    public ResponseEntity<Void> criar(@RequestBody ProdutoRequest request){
        service.criar(request);
        return new ResponseEntity(CREATED);
    }

    @PutMapping("/produtos")
    public void editar(){

    }

    @DeleteMapping("/produtos")
    public void remover(){

    }
}
