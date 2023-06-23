package br.com.fiap.lanchonete.dominio.enumerator;

public enum Categoria {
    BEBIDA(1, "Bebida"),
    LANCHE(2, "Lanche"),
    ACOMPANHAMENTO(3, "Acompanhamento"),
    SOBREMESA(4, "Sobremesa");

    private int id;
    private String tipo;

    Categoria(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public static Categoria from(final int id) {
        for (final Categoria element : Categoria.values()) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }
}
