package br.com.fiap.lanchonete.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class PagamentoRequest {

    @Schema(example = "1")
    private Long id;
    @Schema(example = "payment.created")
    private String action;
    @Schema(example = "v1")
    @JsonProperty("api_version")
    private String apiVersion;

    private Data data;

    @Schema(example = "2023-08-25T10:04:58.396-04:00")
    @JsonProperty("date_created")
    private String dateCreated;

    @Schema(example = "true")
    @JsonProperty("live_mode")
    private Boolean livemode;
    @Schema(example = "payment")
    private String type;
    @Schema(example = "1")
    @JsonProperty("user_id")
    private String userId;

    public String getAction() {
        return action;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public Data getData() {
        return data;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public Long getId() {
        return id;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public String getType() {
        return type;
    }

    public String getUserId() {
        return userId;
    }



    public static class Data{
        @Schema(example = "1")
        private String id;

        public String getId() {
            return id;
        }
    }
}
