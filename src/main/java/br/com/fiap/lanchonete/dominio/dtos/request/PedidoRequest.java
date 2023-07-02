package br.com.fiap.lanchonete.dominio.dtos.request;

import java.util.List;


public class PedidoRequest {
    private List<ProdutoSelecionadoRequest> produtos;
    private boolean isCliente;
    private Integer clienteId;

}
