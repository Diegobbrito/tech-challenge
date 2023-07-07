package br.com.fiap.lanchonete.infraestrutura.adaptadores.dataprovider;

import org.springframework.stereotype.Repository;

@Repository
public class SpringPagamentoDataProviderImp implements SpringPagamentoDataProvider {

    public boolean realizarPagamento(String pagamento) {
        return true;
    }
}
