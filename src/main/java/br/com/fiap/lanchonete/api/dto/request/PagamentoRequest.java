package br.com.fiap.lanchonete.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class PagamentoRequest {
    @Schema(example = "2195065fd66ddad36eb0c351f526fd9a6a7c645c9")
    private String hash;

    public String getHash() {
        return hash;
    }
}
