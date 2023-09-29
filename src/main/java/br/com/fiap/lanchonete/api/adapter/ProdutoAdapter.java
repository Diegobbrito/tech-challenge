package br.com.fiap.lanchonete.api.adapter;

import br.com.fiap.lanchonete.api.dto.response.ProdutoResponse;
import br.com.fiap.lanchonete.core.entity.Produto;
import br.com.fiap.lanchonete.gateway.repository.produto.ProdutoEntity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ProdutoAdapter {

    public static Produto toProduto(ProdutoEntity produtoEntity) {
        final var produto = new Produto(produtoEntity.getNome(), produtoEntity.getDescricao(), produtoEntity.getValor(), CategoriaAdapter.toCategoria(produtoEntity.getCategoria()), produtoEntity.getImagemUrl());
        produto.setId(produtoEntity.getId());
        return produto;
    }

    public static ProdutoResponse toResponse(Produto produto) {
        final var valorDoProduto = formatarParaReal(produto.getValor());
        return new ProdutoResponse(produto.getId(),  produto.getNome(), produto.getDescricao(), valorDoProduto , produto.getImagemUrl());
    }

    private static String formatarParaReal(BigDecimal valor){
        return "R$" + new DecimalFormat("#,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR"))).format(valor);
    }
}
