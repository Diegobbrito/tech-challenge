package br.com.fiap.lanchonete.dominio.adaptadores.services;
import br.com.fiap.lanchonete.dominio.dtos.request.UsuarioRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.CategoriaResponse;
import br.com.fiap.lanchonete.dominio.dtos.response.UsuarioResponse;
import br.com.fiap.lanchonete.dominio.entidades.Usuario;
import br.com.fiap.lanchonete.dominio.portas.interfaces.CategoriaServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.UsuarioServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.CategoriaRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioReporitoryPort;

import java.util.List;

public class CategoriaService implements CategoriaServicePort {

    private final CategoriaRepositoryPort repository;

    public CategoriaService(CategoriaRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoriaResponse> buscarTodas() {
        final var categoria = this.repository.buscarTodas();
        return null;
    }
}
