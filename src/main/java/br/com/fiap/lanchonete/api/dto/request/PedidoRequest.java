package br.com.fiap.lanchonete.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class PedidoRequest {
    private List<ProdutoSelecionadoRequest> produtos;
    @Schema(example = "055.069.020-42")
    private String cpf;

    public List<ProdutoSelecionadoRequest> getProdutos() {
        return produtos;
    }

    public String getCpf() {
        return cpf;
    }
}
