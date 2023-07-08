package br.com.fiap.lanchonete.dominio.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class PedidoRequest {
    private List<ProdutoSelecionadoRequest> produtos;
    @Schema(example = "true")
    private boolean isCliente;
    @Schema(example = "1")
    private Integer clienteId;


    public List<ProdutoSelecionadoRequest> getProdutos() {
        return produtos;
    }

    public boolean isCliente() {
        return isCliente;
    }

    public Integer getClienteId() {
        return clienteId;
    }
}
