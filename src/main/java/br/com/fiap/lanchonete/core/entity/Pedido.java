package br.com.fiap.lanchonete.core.entity;


import br.com.fiap.lanchonete.api.dto.request.PedidoRequest;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.api.dto.response.StatusResponse;
import br.com.fiap.lanchonete.core.enumerator.StatusEnum;
import br.com.fiap.lanchonete.gateway.pedido.PedidoEntity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
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
        this.isCliente = request.isCliente();
        this.valor = BigDecimal.ONE;
        this.produtos = getProdutosSelecionados(request, produtos);
        this.status = status;
    }

    public static PedidoResponse toResponse(Pedido pedido) {
        final var status = new StatusResponse(pedido.getStatus().getTipo());
        return new PedidoResponse(pedido.getId(), formatarParaReal(pedido.getValor()), status);
    }

    public Pedido (PedidoEntity pedido) {
        this.id = pedido.getId();
        this.valor = pedido.getValor();
        this.status = new Status(StatusEnum.from(pedido.getStatus().getId()));
        this.isCliente = pedido.isCliente();
        final var produtos = pedido.getProdutos();
        this.produtos = produtos.stream().map(p ->
            new ProdutoSelecionado(p.getProduto().toProduto(), p.getQuantidade())
        ).collect(Collectors.toList());
    }

    private List<ProdutoSelecionado> getProdutosSelecionados(PedidoRequest request, List<Produto> produtos) {
        Map<Integer, Integer> produtoQuantidade = new HashMap<>();
        request.getProdutos().forEach(p ->
            produtoQuantidade.put(p.getProdutoId(), p.getQuantidade())
        );

        this.valor = BigDecimal.ONE;
        return produtos.stream().map(p -> {
            final var quantidade = produtoQuantidade.get(p.getId());
            this.valor = this.valor.add(p.getValor().multiply(BigDecimal.valueOf(quantidade)));
            return new ProdutoSelecionado(p, quantidade);
        }).collect(Collectors.toList());
    }

    public void setStatus(StatusEnum status) {
        this.status = new Status(StatusEnum.from(status.getId()));
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

    public String getValorFormatado() {
        return formatarParaReal(this.valor);
    }
}
