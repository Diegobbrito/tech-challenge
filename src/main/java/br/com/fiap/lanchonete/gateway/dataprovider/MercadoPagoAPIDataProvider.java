package br.com.fiap.lanchonete.gateway.dataprovider;

import br.com.fiap.lanchonete.core.entity.Pedido;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoAPIDataProvider{

    public String criarPagamento(Pedido pedido) {
        return "00020101021243650016COM.MERCADOLIBRE02013063638f1192a-5fd1-4180-a180-8bcae3556bc35204000053039865802BR5925IZABEL AAAA DE MELO6007BARUERI62070503***63040B6D";
    }

    public boolean validaPagamento(String pagamentoId) {
        return true;
    }
}