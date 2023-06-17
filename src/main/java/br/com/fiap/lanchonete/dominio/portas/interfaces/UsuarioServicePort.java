package br.com.fiap.lanchonete.dominio.portas.interfaces;

import br.com.fiap.lanchonete.dominio.dtos.request.ProdutoRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.UsuarioRequest;
import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;
import br.com.fiap.lanchonete.dominio.dtos.response.UsuarioResponse;

import java.util.List;

public interface UsuarioServicePort {
    List<UsuarioResponse> buscarTodos();
    void criar(UsuarioRequest produto);
}
