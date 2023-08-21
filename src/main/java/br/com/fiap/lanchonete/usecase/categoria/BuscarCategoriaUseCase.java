package br.com.fiap.lanchonete.usecase.categoria;
import br.com.fiap.lanchonete.api.dto.response.CategoriaResponse;
import br.com.fiap.lanchonete.dominio.models.Categoria;
import br.com.fiap.lanchonete.dominio.portas.repositorios.CategoriaRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class BuscarCategoriaUseCase implements IBuscarCategoria {

    private final CategoriaRepositoryPort repository;

    public BuscarCategoriaUseCase(CategoriaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoriaResponse> buscarTodas() {
        final var categoria = this.repository.buscarTodas();
        return categoria.stream().map(Categoria::toCategoriaResponse).collect(Collectors.toList());
    }
}
