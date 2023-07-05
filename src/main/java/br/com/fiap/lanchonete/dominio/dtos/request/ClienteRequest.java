package br.com.fiap.lanchonete.dominio.dtos.request;


import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public class ClienteRequest {
    private String nome;
    private EmailRequest email;
    @CPF
    private String cpf;

    public String getNome() {
        return nome;
    }

    public EmailRequest getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
