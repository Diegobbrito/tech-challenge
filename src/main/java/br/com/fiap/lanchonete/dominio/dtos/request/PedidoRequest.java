package br.com.fiap.lanchonete.dominio.dtos.request;

import java.util.Map;

public class PedidoRequest {
    private Map<Integer, Integer> produtos;
    private boolean isCliente;
    private Integer clienteId;


    public Map<Integer, Integer> getProdutos() {
        return produtos;
    }

    public boolean isCliente() {
        return isCliente;
    }

    public Integer getClienteId() {
        return clienteId;
    }
}
