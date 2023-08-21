package br.com.fiap.lanchonete.gateway.dataprovider;

public interface SpringPagamentoDataProvider {
    boolean realizarPagamento(String pagamento);
}
