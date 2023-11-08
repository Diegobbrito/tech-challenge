package br.com.fiap.lanchonete.core.usecase.categoria;

import br.com.fiap.lanchonete.api.adapter.CategoriaAdapter;
import br.com.fiap.lanchonete.api.dto.response.CategoriaResponse;
import br.com.fiap.lanchonete.config.UseCase;
import br.com.fiap.lanchonete.gateway.repository.ICategoriaRepository;

import java.util.List;
import java.util.stream.Collectors;
@UseCase
public class BuscarCategoriaUseCase implements IBuscarCategoria {

    private final ICategoriaRepository repository;

    public BuscarCategoriaUseCase(ICategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoriaResponse> buscarTodas() {
        final var categoria = this.repository.buscarTodas();
        return categoria.stream().map(CategoriaAdapter::toResponse).collect(Collectors.toList());
    }
}
