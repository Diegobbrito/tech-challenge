package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Produtos", description = "Controle de produtos")
@RestController
public class ProdutoController {

    private final ProdutoServicePort service;
    public ProdutoController(ProdutoServicePort service) {
        this.service = service;
    }

    @Operation(summary = "Listagem de todos os produtos")
    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoResponse>> listarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @Operation(summary = "Listagem de produtos por categoria")
    @GetMapping("/produtos/{categoriaId}")
    public ResponseEntity<List<ProdutoResponse>> listarPorCategoria(@PathVariable Integer categoriaId){
        return ResponseEntity.ok(service.buscarPorCategoria(categoriaId));
    }
    @Operation(summary = "Criação de produto")
    @PostMapping("/produtos")
    public ResponseEntity<Void> criar(@RequestBody ProdutoRequest request){
        service.criar(request);
        return new ResponseEntity(CREATED);
    }

    @Operation(summary = "Alteração de produto")
    @PutMapping("/produtos/{id}")
    public ResponseEntity<Void> editar(@PathVariable Integer id, @RequestBody ProdutoRequest request){
        service.atualizar(id, request);
        return ResponseEntity.ok().build();
    }
    @Operation(summary = "Deleção de produto")
    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        service.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
