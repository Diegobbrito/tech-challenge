package br.com.fiap.lanchonete.aplicacao.adaptadores.handler;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.exceptions.ClienteInexistenteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handlerClienteInexistenteException(ClienteInexistenteException ex){
        return  ResponseEntity.badRequest().build();
    }
}
