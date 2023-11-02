package br.com.fiap.lanchonete.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record PedidoStatusRequest(
        @Schema(example = "3", allowableValues = {"1","2","3","4","5"},
        description = """
            Id do Status desejado:
            1 - Aguardando Pagamento
            2 - Recebido
            3 - Em preparação
            4 - Pronto
            5 - Finalizado
            """)
        Integer statusId) {
}
