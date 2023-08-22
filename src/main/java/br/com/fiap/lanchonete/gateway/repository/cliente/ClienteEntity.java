package br.com.fiap.lanchonete.gateway.repository.cliente;

import br.com.fiap.lanchonete.core.entity.Cliente;
import br.com.fiap.lanchonete.gateway.repository.pedido.PedidoEntity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoEntity> pedidos;

    public ClienteEntity(Cliente cliente) {
        this.cpf = cliente.getCpf().getValor();
        this.email = cliente.getEmail().getValor();
        this.nome = cliente.getNome();
        this.id = cliente.getId();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
