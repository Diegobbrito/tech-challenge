package br.com.fiap.lanchonete.gateway.repository.pedido;

import br.com.fiap.lanchonete.core.enumerator.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "status_pedido")
@Data
@NoArgsConstructor
public class StatusPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;

    public StatusPedidoEntity(StatusEnum status) {
        this.id = status.getId();
        this.titulo = status.getTipo();
    }
}
