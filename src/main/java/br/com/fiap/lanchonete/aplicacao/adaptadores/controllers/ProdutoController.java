package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    private ProdutoServicePort service;
    public ProdutoController(ProdutoServicePort service) {
        this.service = service;
    }

    @GetMapping
    public List<ProdutoResponse> listarPorCategoria(){
        return service.buscarTodos();
    }

    @PostMapping
    public void criar(ProdutoRequest request){
        service.criar(request);
    }

    @PutMapping
    public void editar(){

    }

    @DeleteMapping
    public void remover(){

    }
}
