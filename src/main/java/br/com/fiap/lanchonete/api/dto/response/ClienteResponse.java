package br.com.fiap.lanchonete.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class ClienteResponse {
    @Schema(example = "05506902042")
    private String cpf;
    @Schema(example = "Diego")
    private String nome;
    @Schema(example = "diego@teste.com")
    private String email;

    public ClienteResponse(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
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
