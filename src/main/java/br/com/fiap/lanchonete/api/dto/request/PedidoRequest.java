package br.com.fiap.lanchonete.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record PedidoRequest (
        List<ProdutoSelecionadoRequest> produtos,
        @Schema(example = "055.069.020-42")
        String cpf
){
}
