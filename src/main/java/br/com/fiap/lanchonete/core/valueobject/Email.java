package br.com.fiap.lanchonete.core.valueobject;

import br.com.fiap.lanchonete.core.exception.EmailInvalidoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String valor;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);


    public Email(String email) {
        if(validarEmail(email)){
            this.valor = email;
        }
        else{
            throw new EmailInvalidoException("Email inválido");
        }
    }

    public static boolean validarEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getValor() {
        return valor;
    }
}
