package br.com.fiap.lanchonete.core.entity;

import br.com.fiap.lanchonete.core.valueobject.Cpf;
import br.com.fiap.lanchonete.core.valueobject.Email;
import br.com.fiap.lanchonete.gateway.repository.cliente.ClienteEntity;

public class Cliente {

    private int id;
    private Cpf cpf;
    private Email email;
    private String nome;

    public Cliente(String cpf, String nome, String email) {
        this.cpf = new Cpf(cpf);
        this.email = new Email(email);
        this.nome = nome;
    }

    public Cliente(ClienteEntity cliente) {
        this.id = cliente.getId();
        this.cpf = new Cpf(cliente.getCpf());
        this.email = new Email(cliente.getEmail());
        this.nome = cliente.getNome();
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

    public int getId() {
        return id;
    }
}
