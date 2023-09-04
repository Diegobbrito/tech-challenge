package br.com.fiap.lanchonete.core.enumerator;

public enum StatusEnum {

    PAGAMENTOPENDENTE(1, "PAGAMENTOPENDENTE"),
    RECEBIDO(2, "RECEBIDO"),
    PREPARANDO(3, "PREPARANDO"),
    PRONTO(4, "PRONTO"),
    FINALIZADO(5, "FINALIZADO");

    private int id;
    private String tipo;


    StatusEnum(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public static StatusEnum from(final int id) {
        for (final StatusEnum element : StatusEnum.values()) {
            if (element.getId() == id) {
                return element;
            }
        }
        throw new IllegalArgumentException("Status inexistente");
    }
}