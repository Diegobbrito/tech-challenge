package br.com.fiap.lanchonete.dominio.dtos.response;

public class PedidoResponse {

    private Integer id;
    private String valorTotal;
    private StatusResponse status;

    public PedidoResponse(Integer id, String valor, StatusResponse status) {
        this.id = id;
        this.valorTotal = valor;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public StatusResponse getStatus() {
        return status;
    }
}
