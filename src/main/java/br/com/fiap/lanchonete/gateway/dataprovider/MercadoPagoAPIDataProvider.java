package br.com.fiap.lanchonete.gateway.dataprovider;

import br.com.fiap.lanchonete.core.entity.Pedido;
import com.mercadopago.client.common.PhoneRequest;
import com.mercadopago.client.payment.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoAPIDataProvider{

    public String criarPagamento(Pedido entity) {
        PaymentClient client = new PaymentClient();

        List<PaymentItemRequest> items = new ArrayList<>();

        PaymentItemRequest item =
                PaymentItemRequest.builder()
                        .id("PR0001")
                        .title("Point Mini")
                        .description("Producto Point para cobros con tarjetas mediante bluetooth")
                        .pictureUrl(
                                "https://http2.mlstatic.com/resources/frontend/statics/growth-sellers-landings/device-mlb-point-i_medium@2x.png")
                        .categoryId("electronics")
                        .quantity(1)
                        .unitPrice(new BigDecimal("58.8"))
                        .build();

        items.add(item);

        PaymentCreateRequest createRequest =
                PaymentCreateRequest.builder()
                        .additionalInfo(
                                PaymentAdditionalInfoRequest.builder()
                                        .items(items)
                                        .payer(
                                                PaymentAdditionalInfoPayerRequest.builder()
                                                        .firstName("Test")
                                                        .lastName("Test")
                                                        .phone(
                                                                PhoneRequest.builder().areaCode("11").number("987654321").build())
                                                        .build())
                                        .shipments(
                                                PaymentShipmentsRequest.builder()
                                                        .receiverAddress(
                                                                PaymentReceiverAddressRequest.builder()
                                                                        .zipCode("12312-123")
                                                                        .stateName("Rio de Janeiro")
                                                                        .cityName("Buzios")
                                                                        .streetName("Av das Nacoes Unidas")
                                                                        .streetNumber("3003")
                                                                        .build())
                                                        .build())
                                        .build())
                        .description("Payment for product")
                        .externalReference("MP0001")
                        .installments(1)
                        .order(PaymentOrderRequest.builder().type("mercadolibre").build())
                        .payer(PaymentPayerRequest.builder().entityType("individual").type("customer").build())
                        .paymentMethodId("visa")
                        .transactionAmount(new BigDecimal("58.8"))
                        .build();

        try {
            client.create(createRequest);
        } catch (MPException | MPApiException e) {
            throw new RuntimeException(e);
        }
        return "00020101021243650016COM.MERCADOLIBRE02013063638f1192a-5fd1-4180-a180-8bcae3556bc35204000053039865802BR5925IZABEL AAAA DE MELO6007BARUERI62070503***63040B6D";
    }

    public boolean validaPagamento(String pagamentoId) {
        return true;
    }


}
