package br.com.fiap.lanchonete.dominio.models;

import br.com.fiap.lanchonete.dominio.dtos.request.EmailRequest;
import br.com.fiap.lanchonete.dominio.valueobject.Email;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ClienteEntity;

public class Cliente {

    private int id;
    private String cpf;
    private Email email;
    private String nome;

    public Cliente(String cpf, String nome, EmailRequest email) {
        final String cpfFormatado = formatarCpf(cpf);
        if(cpfFormatado.length() != 11){
            throw new IllegalArgumentException("Cpf inválido");
        }
        this.cpf = cpfFormatado;
        this.email = new Email(email.getEmail());
        this.nome = nome;
    }

    public Cliente(ClienteEntity cliente) {
        this.cpf = cliente.getCpf();
        this.email = new Email(cliente.getEmail());
        this.nome = cliente.getNome();
    }

    private String formatarCpf(String cpf) {
        return cpf.trim().replaceAll("\\.", "").replaceAll("-", "");
    }

    public String getCpf() {
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
