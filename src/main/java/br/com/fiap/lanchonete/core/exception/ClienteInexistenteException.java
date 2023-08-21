package br.com.fiap.lanchonete.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClienteInexistenteException extends RuntimeException {
    public ClienteInexistenteException(String mensagem) {
        super(mensagem);
    }
}
