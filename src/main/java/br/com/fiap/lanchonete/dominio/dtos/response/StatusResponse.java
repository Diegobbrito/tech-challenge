package br.com.fiap.lanchonete.dominio.dtos.response;

public class StatusResponse {
    private Integer id;
    private String descricao;

    public StatusResponse(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
