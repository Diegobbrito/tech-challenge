package br.com.fiap.lanchonete.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class CpfRequest {
    @Schema(example = "055.069.020-42")
    private String valor;

    public String getValor() {
        return valor;
    }
}
