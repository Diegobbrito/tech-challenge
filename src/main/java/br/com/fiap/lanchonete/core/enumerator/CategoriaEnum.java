package br.com.fiap.lanchonete.core.enumerator;

public enum CategoriaEnum {
    LANCHE(1),
    BEBIDA(2),
    ACOMPANHAMENTO(3),
    SOBREMESA(4),
    COMBO(5);

    private int id;


    CategoriaEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static CategoriaEnum from(final int id) {
        for (final CategoriaEnum element : CategoriaEnum.values()) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }
}
