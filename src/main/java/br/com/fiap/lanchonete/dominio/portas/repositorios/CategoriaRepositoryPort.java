package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Categoria;

import java.util.List;

public interface CategoriaRepositoryPort {
    List<Categoria> buscarTodas();
}
