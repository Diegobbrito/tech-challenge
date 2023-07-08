package br.com.fiap.lanchonete.dominio.dtos.response;

import br.com.fiap.lanchonete.dominio.models.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;

public class ClienteResponse {
    @Schema(example = "1")
    private int id;
    @Schema(example = "05506902042")
    private String cpf;
    @Schema(example = "Diego")
    private String nome;
    @Schema(example = "diego@teste.com")
    private String email;
    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.cpf = cliente.getCpf().getValor();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail().getValor();
    }

    public int getId() {
        return id;
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
