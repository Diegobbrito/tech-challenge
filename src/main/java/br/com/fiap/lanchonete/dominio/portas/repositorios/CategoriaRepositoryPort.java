package br.com.fiap.lanchonete.dominio.portas.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Usuario;
import br.com.fiap.lanchonete.dominio.enumerator.Categoria;

import java.util.List;

public interface CategoriaRepositoryPort {
    List<Categoria> buscarTodas();
}
