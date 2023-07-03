package br.com.fiap.lanchonete.dominio.entidades;


import br.com.fiap.lanchonete.dominio.dtos.request.PedidoRequest;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Pedido {
    private Integer id;
    private List<ProdutoSelecionado> produtos;
    private BigDecimal valor;
    private Cliente cliente;
    private boolean isCliente;
    private Status status;
    public Pedido(PedidoRequest request, Cliente cliente, List<Produto> produtos, Status status) {
        this.cliente = cliente;
        this.isCliente = true;
        this.valor = BigDecimal.ONE;
        this.produtos = getProdutosSelecionados(request, produtos);
        this.status = status;
    }

    public Pedido(PedidoRequest request, List<Produto> produtos, Status status) {
        this.cliente = null;
        this.isCliente = false;
        this.valor = BigDecimal.ONE;
        this.produtos = getProdutosSelecionados(request, produtos);
        this.status = status;
    }

    private List<ProdutoSelecionado> getProdutosSelecionados(PedidoRequest request, List<Produto> produtos) {
        return produtos.stream().map(p -> {
            final var quantidade = request.getProdutos().get(p.getId());
            final var valor = p.getValor();
            this.valor.add(valor.multiply(BigDecimal.valueOf(quantidade)));
            return new ProdutoSelecionado(p, quantidade);
        }).collect(Collectors.toList());
    }

    private static String formatarParaReal(BigDecimal valor){
        return "R$" + new DecimalFormat("#,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR"))).format(valor);
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
