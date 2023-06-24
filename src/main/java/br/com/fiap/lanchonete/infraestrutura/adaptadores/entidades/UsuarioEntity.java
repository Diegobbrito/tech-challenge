package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.entidades.Usuario;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String cpf;

    private String email;

    private String senha;


    public UsuarioEntity(Usuario usuario) {
    }

    public UsuarioEntity() {

    }
}
