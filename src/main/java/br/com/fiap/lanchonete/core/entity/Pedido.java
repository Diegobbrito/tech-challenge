package br.com.fiap.lanchonete.core.entity;


import br.com.fiap.lanchonete.core.enumerator.StatusEnum;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {
    private Integer id;
    private List<ProdutoSelecionado> produtos;
    private BigDecimal valor;
    private Cliente cliente;
    private boolean isCliente = false;
    private Status status;
    public Pedido(List<ProdutoSelecionado> produtos, Cliente cliente, Status status) {
        this.cliente = cliente;
        if(cliente != null)
            this.isCliente = true;
        this.valor = BigDecimal.ZERO;
        calculaValorTotalDoPedido(produtos);
        this.produtos = produtos;
        this.status = status;
    }

    private void calculaValorTotalDoPedido(List<ProdutoSelecionado> produtos) {
        produtos.forEach(p ->
            this.valor = this.valor.add(p.getProduto().getValor().multiply(BigDecimal.valueOf(p.getQuantidade())))
        );
    }

    public void setStatus(StatusEnum status) {
        this.status = new Status(StatusEnum.from(status.getId()));
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public List<ProdutoSelecionado> getProdutos() {
        return produtos;
    }
    public BigDecimal getValor() {
        return valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isCliente() {
        return isCliente;
    }

    public Status getStatus() {
        return status;
    }
}
