package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import br.com.fiap.lanchonete.dominio.enumerator.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "status_pedido")
@Getter
@Setter
@NoArgsConstructor
public class StatusPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;

    @OneToMany(mappedBy = "status")
    private List<PedidoEntity> pedidos;

    public StatusPedidoEntity(StatusEnum status) {
        this.id = status.getId();
        this.titulo = status.getTipo();
    }
}
