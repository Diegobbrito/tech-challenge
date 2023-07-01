package br.com.fiap.lanchonete.dominio.entidades;



import br.com.fiap.lanchonete.dominio.dtos.response.ProdutoResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Pedido {
    private Integer id;



    public Pedido() {
    }

    public Integer getId() {
        return id;
    }



    private static String formatarParaReal(BigDecimal valor){
        return "R$" + new DecimalFormat("#,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR"))).format(valor);
    }
}
