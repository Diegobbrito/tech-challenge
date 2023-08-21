package br.com.fiap.lanchonete.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class StatusResponse {
    @Schema(example = "AGUARDANDO PAGAMENTO")
    private String descricao;

    public StatusResponse(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
