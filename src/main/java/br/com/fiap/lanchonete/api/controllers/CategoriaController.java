package br.com.fiap.lanchonete.api.controllers;

import br.com.fiap.lanchonete.api.dto.response.CategoriaResponse;
import br.com.fiap.lanchonete.usecase.categoria.IBuscarCategoria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "Categorias", description = "Controle de categorias")
@RestController
public class CategoriaController {

    private IBuscarCategoria service;
    public CategoriaController(IBuscarCategoria service) {
        this.service = service;
    }

    @Operation(summary = "Lista todas as categorias com suas descrições")
    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaResponse>> categorias(){
       return ResponseEntity.ok(service.buscarTodas());
    }
}
