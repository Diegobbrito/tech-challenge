package br.com.fiap.lanchonete.gateway.dataprovider;

import br.com.fiap.lanchonete.core.entity.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PagamentoDataProvider implements IPagamentoDataProvider {

    private final MercadoPagoAPIDataProvider dataProvider;

    public PagamentoDataProvider(MercadoPagoAPIDataProvider repository) {
        this.dataProvider = repository;
    }

    @Override
    public String criarPagamento(Pedido entity) {
        return dataProvider.criarPagamento(entity);
    }
    @Override
    public boolean validaPagamento(String pagamentoId) {
        return dataProvider.validaPagamento(pagamentoId);
    }
}
