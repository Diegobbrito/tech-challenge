package br.com.fiap.lanchonete.gateway.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    List<PedidoEntity> findByStatusInOrderByDataCriacaoAsc(List<StatusPedidoEntity> status);

    List<PedidoEntity> findAllByStatusInOrderByDataCriacao(List<StatusPedidoEntity> status);

}
