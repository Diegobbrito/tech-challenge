package br.com.fiap.lanchonete.infraestrutura.adaptadores.dataprovider;

import br.com.fiap.lanchonete.dominio.portas.repositorios.PagamentoDataProviderPort;
import org.springframework.stereotype.Component;

@Component
public class PagamentoDataProvider implements PagamentoDataProviderPort {

    private final SpringPagamentoDataProviderImp dataProvider;

    public PagamentoDataProvider(SpringPagamentoDataProviderImp repository) {
        this.dataProvider = repository;
    }

    @Override
    public boolean realizarPagamento(String pagamento) {
        return dataProvider.realizarPagamento(pagamento);
    }
}
