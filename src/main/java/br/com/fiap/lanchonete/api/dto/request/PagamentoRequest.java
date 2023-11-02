package br.com.fiap.lanchonete.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record PagamentoRequest(
        @Schema(example = "1")
        Long id,
        @Schema(example = "payment.created")
        String action,
        @Schema(example = "v1")
        @JsonProperty("api_version")
        String apiVersion,

        Data data,

        @Schema(example = "2023-08-25T10:04:58.396-04:00")
        @JsonProperty("date_created")
        String dateCreated,

        @Schema(example = "true")
        @JsonProperty("live_mode")
        Boolean livemode,
        @Schema(example = "payment")
        String type,
        @Schema(example = "1")
        @JsonProperty("user_id")
        String userId) {
    public record Data(
            @Schema(example = "1")
            String id){

    }
}
