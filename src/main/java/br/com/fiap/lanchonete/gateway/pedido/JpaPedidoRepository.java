package br.com.fiap.lanchonete.gateway.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    List<PedidoEntity> findByStatusIn(List<StatusPedidoEntity> ids);

}
