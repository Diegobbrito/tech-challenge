package br.com.fiap.lanchonete.dominio.dtos.request;


import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public class ClienteRequest {
    private String nome;
    @Email
    private String email;
    @CPF
    private String cpf;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
