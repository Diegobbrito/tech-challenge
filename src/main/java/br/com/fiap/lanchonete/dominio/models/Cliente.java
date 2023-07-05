package br.com.fiap.lanchonete.dominio.models;

import br.com.fiap.lanchonete.dominio.dtos.request.CpfRequest;
import br.com.fiap.lanchonete.dominio.dtos.request.EmailRequest;
import br.com.fiap.lanchonete.dominio.valueobject.Cpf;
import br.com.fiap.lanchonete.dominio.valueobject.Email;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ClienteEntity;

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
