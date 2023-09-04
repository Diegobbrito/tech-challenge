package br.com.fiap.lanchonete.core.entity;

import br.com.fiap.lanchonete.core.enumerator.StatusEnum;

public class Status {
    private Integer id;
    private String tipo;

    public Status(StatusEnum status) {
        this.id = status.getId();
        this.tipo = status.getTipo();
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}