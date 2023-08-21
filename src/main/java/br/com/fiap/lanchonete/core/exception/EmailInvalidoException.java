package br.com.fiap.lanchonete.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailInvalidoException extends RuntimeException {
    public EmailInvalidoException(String msg) {
        super(msg);
    }
}
