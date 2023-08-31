package br.com.fiap.lanchonete.core.valueobject;

import br.com.fiap.lanchonete.core.exception.CpfInvalidoException;

import java.util.InputMismatchException;

public class Cpf {
    private String valor;

    public Cpf(String valor) {
        final String cpf = obterNumerosDoCpf(valor);
        if(!validaCpf(cpf)){
            throw new CpfInvalidoException("Cpf inválido");
        }
        this.valor = cpf;
    }

    private String obterNumerosDoCpf(String cpf) {
        return cpf.trim().replaceAll("\\.", "").replaceAll("-", "");
    }

    public static boolean validaCpf(String cpf) {
        if (cpf.matches("^(\\d)\\1{10}") || cpf.length() != 11)
            return false;

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = cpf.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = cpf.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
        } catch (InputMismatchException erro) {
            return false ;
        }
    }

    public String getValor() {
        return valor;
    }
}
