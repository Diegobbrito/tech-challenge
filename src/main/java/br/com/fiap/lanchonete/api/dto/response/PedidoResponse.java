package br.com.fiap.lanchonete.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

public class PedidoResponse {

    @Schema(example = "1")
    private Integer id;
    @Schema(example = "R$ 24,90")
    private String valorTotal;
    private StatusResponse status;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String qrData;

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

    public String getQrData() {
        return qrData;
    }

    public void setQrData(String qrData) {
        this.qrData = qrData;
    }
}
