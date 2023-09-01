package br.com.fiap.lanchonete.core.entity;

import br.com.fiap.lanchonete.core.valueobject.Cpf;
import br.com.fiap.lanchonete.core.valueobject.Email;

public class Cliente {

    private Integer id;
    private Cpf cpf;
    private Email email;
    private String nome;

    public Cliente(String cpf, String nome, String email) {
        this.cpf = new Cpf(cpf);
        this.email = new Email(email);
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
