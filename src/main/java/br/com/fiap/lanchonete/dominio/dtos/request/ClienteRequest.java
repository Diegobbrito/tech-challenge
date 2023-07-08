package br.com.fiap.lanchonete.dominio.dtos.request;


import io.swagger.v3.oas.annotations.media.Schema;

public class ClienteRequest {
    @Schema(example = "Diego")
    private String nome;
    private EmailRequest email;
    private CpfRequest cpf;

    public String getNome() {
        return nome;
    }

    public EmailRequest getEmail() {
        return email;
    }

    public CpfRequest getCpf() {
        return cpf;
    }
}
