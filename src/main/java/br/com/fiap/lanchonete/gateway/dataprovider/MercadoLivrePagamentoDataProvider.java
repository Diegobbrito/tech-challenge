package br.com.fiap.lanchonete.gateway.dataprovider;

import org.springframework.stereotype.Repository;

@Repository
public class MercadoLivrePagamentoDataProvider implements IPagamentoDataProvider {

    public boolean realizarPagamento(String pagamento) {
        return true;
    }
}
