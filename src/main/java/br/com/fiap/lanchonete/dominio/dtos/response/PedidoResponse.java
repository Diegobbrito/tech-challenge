package br.com.fiap.lanchonete.dominio.dtos.response;

public class PedidoResponse {

    private Integer id;
    private String valotTotal;


    public PedidoResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
