package br.com.fiap.lanchonete.dominio.enumerator;

public enum StatusEnum {
    RECEBIDO(1, "RECEBIDO"),
    PREPARANDO(2, "PREPARANDO"),
    PRONTO(3, "PRONTO"),
    FINALIZADO(4, "FINALIZADO"),
    PAGAMENTOPENDENTE(5, "PAGAMENTOPENDENTE");

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
        return null;
    }
}