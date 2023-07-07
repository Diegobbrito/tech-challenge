package br.com.fiap.lanchonete.dominio.portas.repositorios;

public interface PagamentoDataProviderPort {

    boolean realizarPagamento(String pagamento);
}
