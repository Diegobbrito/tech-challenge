package br.com.fiap.lanchonete.dominio.entidades;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ClienteEntity;

public class Cliente {

    private int id;
    private String cpf;
    private String email;
    private String nome;

    public Cliente(String cpf, String email, String nome) {
        final String cpfFormatado = formatarCpf(cpf);
        if(cpfFormatado.length() != 11){
            throw new IllegalArgumentException("Cpf inválido");
        }
        this.cpf = cpfFormatado;
        this.email = email;
        this.nome = nome;
    }

    public Cliente(ClienteEntity cliente) {
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();
    }

    private String formatarCpf(String cpf) {
        return cpf.trim().replaceAll("\\.", "").replaceAll("-", "");
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
