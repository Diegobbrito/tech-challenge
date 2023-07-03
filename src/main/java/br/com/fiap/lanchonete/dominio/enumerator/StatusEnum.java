package br.com.fiap.lanchonete.dominio.enumerator;

public enum StatusEnum {
    RECEBIDO(1),
    PREPARANDO(2),
    PRONTO(3),
    FINALIZADO(4),
    PAGAMENTOPENDENTE(5);

    private int id;


    StatusEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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