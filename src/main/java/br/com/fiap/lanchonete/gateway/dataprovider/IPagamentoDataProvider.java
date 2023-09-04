package br.com.fiap.lanchonete.gateway.dataprovider;

import br.com.fiap.lanchonete.core.entity.Pedido;

public interface IPagamentoDataProvider {

    String criarPagamento(Pedido entity);
    boolean validaPagamento(String pagamento);
}
