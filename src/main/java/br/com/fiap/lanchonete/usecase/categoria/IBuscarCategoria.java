package br.com.fiap.lanchonete.usecase.categoria;

import br.com.fiap.lanchonete.api.dto.response.CategoriaResponse;

import java.util.List;

public interface IBuscarCategoria {
    List<CategoriaResponse> buscarTodas();

}
