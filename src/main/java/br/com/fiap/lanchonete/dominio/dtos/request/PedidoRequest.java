package br.com.fiap.lanchonete.dominio.dtos.request;

import java.util.List;
import java.util.Map;

public class PedidoRequest {
    private List<ProdutoSelecionadoRequest> produtos;
    private boolean isCliente;
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
