package br.com.fiap.lanchonete.gateway.dataprovider;

import br.com.fiap.lanchonete.core.entity.Pedido;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoAPIDataProvider{

    @Value("${mercado-pago.access-token:teste}")
    private String accessToken;

    @Value("${mercado-pago.notification-url:teste}")
    private String notificationUrl;

    public String criarPagamento(Pedido pedido) {
        MercadoPagoConfig.setAccessToken(accessToken);
        PaymentClient client = new PaymentClient();
        List<PaymentItemRequest> items = new ArrayList<>();
        pedido.getProdutos().forEach(p ->{
            final var produto = p.getProduto();
            PaymentItemRequest item =
                    PaymentItemRequest.builder()
                            .id(produto.getId().toString())
                            .title(produto.getNome())
                            .description(produto.getDescricao())
                            .pictureUrl(produto.getImagemUrl())
                            .categoryId(produto.getCategoria().getDescricao())
                            .quantity(p.getQuantidade())
                            .unitPrice(produto.getValor())
                            .build();
            items.add(item);
        });

        PaymentCreateRequest createRequest =
                PaymentCreateRequest.builder()
                        .additionalInfo(
                                PaymentAdditionalInfoRequest.builder()
                                        .items(items)
                                        .payer(
                                                PaymentAdditionalInfoPayerRequest.builder()
                                                        .firstName(pedido.getCliente().getNome())
                                                        .build())
                                        .build())
                        .description("Pagamento de pedido na lanchonete")
                        .notificationUrl(notificationUrl)
                        .externalReference(pedido.getId().toString())
                        .installments(1)
                        .paymentMethodId("pix")
                        .transactionAmount(pedido.getValor())
                        .build();

        try {
            Payment payment = client.create(createRequest);
            return payment.getPointOfInteraction().getTransactionData().getQrCode();
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validaPagamento(String pagamentoId) {
        return true;
    }


}
