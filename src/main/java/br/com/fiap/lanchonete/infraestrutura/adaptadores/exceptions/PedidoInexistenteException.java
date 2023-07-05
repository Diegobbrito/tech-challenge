package br.com.fiap.lanchonete.infraestrutura.adaptadores.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PedidoInexistenteException extends RuntimeException {
    public PedidoInexistenteException(String mensagem) {
        super(mensagem);
    }
}
