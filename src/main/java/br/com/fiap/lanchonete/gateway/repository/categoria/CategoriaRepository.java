package br.com.fiap.lanchonete.gateway.repository.categoria;

import br.com.fiap.lanchonete.api.adapter.CategoriaAdapter;
import br.com.fiap.lanchonete.core.entity.Categoria;
import br.com.fiap.lanchonete.gateway.repository.ICategoriaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaRepository implements ICategoriaRepository {

    private final JpaCategoriaRepository repository;

    public CategoriaRepository(JpaCategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> buscarTodas() {
        final var categorias = repository.findAll();
        return categorias.stream().map(CategoriaAdapter::toCategoria).collect(Collectors.toList());
    }
}
