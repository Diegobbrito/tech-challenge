package br.com.fiap.lanchonete.dominio.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class CategoriaResponse {

    @Schema(example = "4")
    private int id;
    @Schema(example = "Sobremesas")
    private String tipo;
    @Schema(example = "Sorvetes e doces váriados")
    private String descricao;

    public CategoriaResponse(int id, String tipo, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }
}
