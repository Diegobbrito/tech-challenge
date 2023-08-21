package br.com.fiap.lanchonete.core.entity;

import br.com.fiap.lanchonete.api.dto.request.CpfRequest;
import br.com.fiap.lanchonete.api.dto.request.EmailRequest;
import br.com.fiap.lanchonete.core.valueobject.Cpf;
import br.com.fiap.lanchonete.core.valueobject.Email;
import br.com.fiap.lanchonete.gateway.cliente.ClienteEntity;

public class Cliente {

    private int id;
    private Cpf cpf;
    private Email email;
    private String nome;

    public Cliente(CpfRequest cpf, String nome, EmailRequest email) {

        this.cpf = new Cpf(cpf.getValor());
        this.email = new Email(email.getValor());
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
