package br.com.fiap.lanchonete.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class EmailRequest {
    @Schema(example = "diego@test.com")
    private String valor;

    public String getValor() {
        return valor;
    }
}
