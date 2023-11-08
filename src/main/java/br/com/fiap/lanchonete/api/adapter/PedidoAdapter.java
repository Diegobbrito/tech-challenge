package br.com.fiap.lanchonete.api.adapter;

import br.com.fiap.lanchonete.api.dto.request.PedidoRequest;
import br.com.fiap.lanchonete.api.dto.response.PagamentoStatusResponse;
import br.com.fiap.lanchonete.api.dto.response.PedidoResponse;
import br.com.fiap.lanchonete.api.dto.response.StatusResponse;
import br.com.fiap.lanchonete.core.entity.*;
import br.com.fiap.lanchonete.core.enumerator.StatusEnum;
import br.com.fiap.lanchonete.gateway.repository.pedido.PedidoEntity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class PedidoAdapter {

    public static Pedido toPedido(PedidoEntity pedidoEntity) {
        final var status = new Status(StatusEnum.from(pedidoEntity.getStatus().getId()));
        final var produtos =  pedidoEntity.getProdutos().stream().map(p ->
                new ProdutoSelecionado(ProdutoAdapter.toProduto(p.getProduto()), p.getQuantidade())
        ).collect(Collectors.toList());
        Cliente cliente = null;
        if(pedidoEntity.getCliente() != null)
            cliente = ClienteAdapter.toCliente(pedidoEntity.getCliente()) ;
        final var pedido =  new Pedido(produtos, cliente, status);
        pedido.setId(pedidoEntity.getId());
       return pedido;
    }

    public static PedidoResponse toResponse(Pedido pedido, String qrData) {
        final var status = new StatusResponse(pedido.getStatus().getTipo());
        final var response = new PedidoResponse(pedido.getId(), formatarParaReal(pedido.getValor()), status);
        response.setQrData(qrData);
        return response;
    }
    public static PedidoResponse toResponse(Pedido pedido) {
        final var status = new StatusResponse(pedido.getStatus().getTipo());
        return  new PedidoResponse(pedido.getId(), formatarParaReal(pedido.getValor()), status);
    }
    public static Pedido toPedido(PedidoRequest request, Cliente cliente, List<Produto> produtos, Status status) {
        return new Pedido(getProdutosSelecionados(request, produtos), cliente, status);
    }

    private static List<ProdutoSelecionado> getProdutosSelecionados(PedidoRequest request, List<Produto> produtos) {
        Map<Integer, Integer> produtoQuantidade = new HashMap<>();
        request.produtos().forEach(p ->
                produtoQuantidade.put(p.produtoId(), p.quantidade())
        );
        return produtos.stream().map(p -> new ProdutoSelecionado(p, produtoQuantidade.get(p.getId()))).collect(Collectors.toList());
    }

    private static String formatarParaReal(BigDecimal valor){
        return "R$" + new DecimalFormat("#,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR"))).format(valor);
    }

    public static PedidoEntity toUpdate(Pedido pedido) {
        return new PedidoEntity(pedido);
    }

    public static PedidoResponse toResponseUpdate(Pedido pedido) {
        final var status = new StatusResponse(pedido.getStatus().getTipo());
        return new PedidoResponse(pedido.getId(), formatarParaReal(pedido.getValor()), status);
    }

    public static PagamentoStatusResponse toPedidoStatus(String status) {
        return new PagamentoStatusResponse(status);
    }
}
