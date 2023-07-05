package br.com.fiap.lanchonete.infraestrutura.adaptadores.dataprovider;

public interface SpringPagamentoDataProvider {
    boolean realizarPagamento(String pagamento);
}
