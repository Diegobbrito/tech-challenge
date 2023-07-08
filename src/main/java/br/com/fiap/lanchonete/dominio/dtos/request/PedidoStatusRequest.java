package br.com.fiap.lanchonete.dominio.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class PedidoStatusRequest {

    @Schema(example = "2", allowableValues = {"1","2","3","4","5"}, description = """
            Id do Status desejado:
            1 - Aguardando Pagamento
            2 - Recebido
            3 - Em preparação
            4 - Pronto
            5 - Finalizado""")
    private Integer statusId;

    public Integer getStatusId() {
        return statusId;
    }
}
