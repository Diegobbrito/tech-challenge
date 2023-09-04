package br.com.fiap.lanchonete.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClienteCadastradoException extends RuntimeException {
    public ClienteCadastradoException(String mensagem) {
        super(mensagem);
    }
}
