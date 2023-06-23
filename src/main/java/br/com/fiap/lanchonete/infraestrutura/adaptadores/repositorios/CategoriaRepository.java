package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.dominio.entidades.Usuario;
import br.com.fiap.lanchonete.dominio.enumerator.Categoria;
import br.com.fiap.lanchonete.dominio.portas.repositorios.CategoriaRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositorios.UsuarioReporitoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaRepository implements CategoriaRepositoryPort {

    private final SpringCategoriaRepository repository;

    public CategoriaRepository(SpringCategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> buscarTodos() {
        final var produtos = repository.findAll();
        return null;
    }

}
