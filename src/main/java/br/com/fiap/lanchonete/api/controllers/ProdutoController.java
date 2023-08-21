package br.com.fiap.lanchonete.api.controllers;

import br.com.fiap.lanchonete.api.dto.request.ProdutoRequest;
import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;
import br.com.fiap.lanchonete.usecase.produto.IBuscarProduto;
import br.com.fiap.lanchonete.usecase.produto.ICriarProduto;
import br.com.fiap.lanchonete.usecase.produto.IGerenciarProduto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Produtos", description = "Controle de produtos")
@RestController
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
    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoResponse>> listarTodos(){
        return ResponseEntity.ok(buscarProdutoUseCase.buscarTodos());
    }

    @Operation(summary = "Listagem de produtos por categoria")
    @GetMapping("/produtos/{categoriaId}")
    public ResponseEntity<List<ProdutoResponse>> listarPorCategoria(@Parameter(example = "1") @PathVariable Integer categoriaId){
        return ResponseEntity.ok(buscarProdutoUseCase.buscarPorCategoria(categoriaId));
    }
    @Operation(summary = "Criação de produto")
    @PostMapping("/produtos")
    public ResponseEntity<ProdutoResponse> criar(@RequestBody ProdutoRequest request){
        return new ResponseEntity(criarProdutoUseCase.criar(request), CREATED);
    }

    @Operation(summary = "Alteração de produto")
    @PutMapping("/produtos/{id}")
    public ResponseEntity<ProdutoResponse> editar(@Parameter(example = "1") @PathVariable Integer id, @RequestBody ProdutoRequest request){
        gerenciarProdutoUseCase.atualizar(id, request);
        return ResponseEntity.ok().build();
    }
    @Operation(summary = "Deleção de produto")
    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> remover(@Parameter(example = "1") @PathVariable Integer id){
        gerenciarProdutoUseCase.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}