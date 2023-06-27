package br.com.fiap.lanchonete.dominio.portas.interfaces;

import br.com.fiap.lanchonete.dominio.dtos.response.CategoriaResponse;

import java.util.List;

public interface CategoriaServicePort {
    List<CategoriaResponse> buscarTodas();

}
