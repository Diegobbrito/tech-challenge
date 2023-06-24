package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Categoria;
import br.com.fiap.lanchonete.dominio.portas.repositorios.CategoriaRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaRepository implements CategoriaRepositoryPort {

    private final SpringCategoriaRepository repository;

    public CategoriaRepository(SpringCategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> buscarTodas() {
        final var categoria = repository.findAll();

        return categoria.stream().map(CategoriaEntity::toCategoria).collect(Collectors.toList());

    }
}
