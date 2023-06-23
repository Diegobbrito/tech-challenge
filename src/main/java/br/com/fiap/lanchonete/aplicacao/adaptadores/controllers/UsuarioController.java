package br.com.fiap.lanchonete.aplicacao.adaptadores.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @PostMapping("/usuarios")
    public void cadastrar(){

    }
}
