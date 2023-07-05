package br.com.fiap.lanchonete.infraestrutura.adaptadores.exceptions;

public class EmailInvalidoException extends RuntimeException {
    public EmailInvalidoException(String msg) {
        super(msg);
    }
}
