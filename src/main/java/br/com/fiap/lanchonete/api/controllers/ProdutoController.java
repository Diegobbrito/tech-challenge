package br.com.fiap.lanchonete.api.controllers;

import br.com.fiap.lanchonete.api.dto.request.ProdutoRequest;
import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;
import br.com.fiap.lanchonete.core.usecase.produto.IBuscarProduto;
import br.com.fiap.lanchonete.core.usecase.produto.ICriarProduto;
import br.com.fiap.lanchonete.core.usecase.produto.IGerenciarProduto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "Produtos", description = "Controle de produtos")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final IBuscarProduto buscarProdutoUseCase;
    private final ICriarProduto criarProdutoUseCase;
    private final IGerenciarProduto gerenciarProdutoUseCase;
    public ProdutoController(IBuscarProduto buscarProdutoUseCase, ICriarProduto criarProdutoUseCase, IGerenciarProduto gerenciarProdutoUseCase) {
        this.buscarProdutoUseCase = buscarProdutoUseCase;
        this.criarProdutoUseCase = criarProdutoUseCase;
        this.gerenciarProdutoUseCase = gerenciarProdutoUseCase;
    }

    @Operation(summary = "Listagem de todos os produtos")
    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listarTodos(){
        return ResponseEntity.ok(buscarProdutoUseCase.buscarTodos());
    }

    @Operation(summary = "Listagem de produtos por categoria")
    @GetMapping("/{categoriaId}")
    public ResponseEntity<List<ProdutoResponse>> listarPorCategoria(@Parameter(example = "1") @PathVariable Integer categoriaId){
        return ResponseEntity.ok(buscarProdutoUseCase.buscarPorCategoria(categoriaId));
    }
    @Operation(summary = "Criação de produto")
    @PostMapping
    public ResponseEntity<ProdutoResponse> criar(@RequestBody ProdutoRequest request){
        final var response = criarProdutoUseCase.criar(request);
        final var uri = URI.create("/produtos/" + response.id());
        return ResponseEntity.created(uri).body(response);
    }

    @Operation(summary = "Alteração de produto")
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> editar(@Parameter(example = "1") @PathVariable Integer id, @RequestBody ProdutoRequest request){
        return ResponseEntity.ok(gerenciarProdutoUseCase.atualizar(id, request));
    }
    @Operation(summary = "Deleção de produto")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@Parameter(example = "1") @PathVariable Integer id){
        gerenciarProdutoUseCase.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
