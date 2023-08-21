package br.com.fiap.lanchonete.gateway.repository;

public interface IPagamentoDataProvider {

    boolean realizarPagamento(String pagamento);
}
