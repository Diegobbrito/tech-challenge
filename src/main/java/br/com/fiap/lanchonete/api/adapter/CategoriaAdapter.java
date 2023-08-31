package br.com.fiap.lanchonete.api.adapter;

import br.com.fiap.lanchonete.api.dto.response.CategoriaResponse;
import br.com.fiap.lanchonete.core.entity.Categoria;

public class CategoriaAdapter {

    public static CategoriaResponse toResponse(Categoria categoria){
        return new CategoriaResponse(categoria.getId(), categoria.getTipo(), categoria.getDescricao());
    }
}
