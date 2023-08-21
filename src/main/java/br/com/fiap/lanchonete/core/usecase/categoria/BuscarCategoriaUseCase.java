package br.com.fiap.lanchonete.core.usecase.categoria;
import br.com.fiap.lanchonete.api.dto.response.CategoriaResponse;
import br.com.fiap.lanchonete.core.entity.Categoria;
import br.com.fiap.lanchonete.gateway.repository.ICategoriaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BuscarCategoriaUseCase implements IBuscarCategoria {

    private final ICategoriaRepository repository;

    public BuscarCategoriaUseCase(ICategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoriaResponse> buscarTodas() {
        final var categoria = this.repository.buscarTodas();
        return categoria.stream().map(Categoria::toCategoriaResponse).collect(Collectors.toList());
    }
}
