package br.com.fiap.lanchonete.gateway.dataprovider;

import br.com.fiap.lanchonete.gateway.repository.IPagamentoDataProvider;
import org.springframework.stereotype.Component;

@Component
public class PagamentoDataProvider implements IPagamentoDataProvider {

    private final MercadoLivrePagamentoDataProvider dataProvider;

    public PagamentoDataProvider(MercadoLivrePagamentoDataProvider repository) {
        this.dataProvider = repository;
    }

    @Override
    public boolean realizarPagamento(String pagamento) {
        return dataProvider.realizarPagamento(pagamento);
    }
}
