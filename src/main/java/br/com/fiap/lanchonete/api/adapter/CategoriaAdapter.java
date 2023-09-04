package br.com.fiap.lanchonete.api.adapter;

import br.com.fiap.lanchonete.api.dto.response.CategoriaResponse;
import br.com.fiap.lanchonete.core.entity.Categoria;
import br.com.fiap.lanchonete.gateway.repository.categoria.CategoriaEntity;

public class CategoriaAdapter {

    public static Categoria toCategoria(CategoriaEntity entity) {
        final var categoria = new Categoria(entity.getId());
        categoria.setTipo(entity.getTitulo());
        categoria.setDescricao(entity.getDescricao());
        return categoria;
    }

    public static CategoriaResponse toResponse(Categoria categoria){
        return new CategoriaResponse(categoria.getId(), categoria.getTipo(), categoria.getDescricao());
    }
}
