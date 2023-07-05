package br.com.fiap.lanchonete.dominio.dtos.request;


public class ClienteRequest {
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
