package br.com.fiap.lanchonete.gateway.repository;

import br.com.fiap.lanchonete.core.entity.Categoria;

import java.util.List;

public interface ICategoriaRepository {
    List<Categoria> buscarTodas();
}
