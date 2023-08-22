package br.com.fiap.lanchonete.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class PedidoRequest {
    private List<ProdutoSelecionadoRequest> produtos;
    @Schema(example = "1")
    private String cpf;

    public List<ProdutoSelecionadoRequest> getProdutos() {
        return produtos;
    }

    public String getCpf() {
        return cpf;
    }
}
