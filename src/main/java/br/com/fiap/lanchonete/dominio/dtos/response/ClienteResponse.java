package br.com.fiap.lanchonete.dominio.dtos.response;

import br.com.fiap.lanchonete.dominio.models.Cliente;

public class ClienteResponse {

    private String cpf;
    private String nome;
    private String email;
    public ClienteResponse(Cliente cliente) {
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
