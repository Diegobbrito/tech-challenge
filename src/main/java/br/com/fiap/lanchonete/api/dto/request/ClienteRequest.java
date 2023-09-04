package br.com.fiap.lanchonete.api.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;

public class ClienteRequest {
    @Schema(example = "Diego")
    private String nome;
    @Schema(example = "diego@test.com")
    private String email;
    @Schema(example = "055.069.020-42")
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
