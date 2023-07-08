package br.com.fiap.lanchonete.dominio.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class PedidoResponse {

    @Schema(example = "1")
    private Integer id;
    @Schema(example = "R$ 24,90")
    private String valorTotal;
    private StatusResponse status;

    public PedidoResponse(Integer id, String valor, StatusResponse status) {
        this.id = id;
        this.valorTotal = valor;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public StatusResponse getStatus() {
        return status;
    }
}
