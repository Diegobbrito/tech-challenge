package br.com.fiap.lanchonete.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class PagamentoStatusResponse {

    @Schema(example = "Pago")
    private String status;

    public PagamentoStatusResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
