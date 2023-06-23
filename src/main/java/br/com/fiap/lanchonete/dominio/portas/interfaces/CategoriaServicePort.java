package br.com.fiap.lanchonete.dominio.portas.interfaces;

import br.com.fiap.lanchonete.dominio.dtos.request.UsuarioRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.CategoriaResponse;
import br.com.fiap.lanchonete.dominio.dtos.response.UsuarioResponse;

import java.util.List;

public interface CategoriaServicePort {
    List<CategoriaResponse> buscarTodas();

}
