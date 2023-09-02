package br.com.fiap.lanchonete.gateway.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPedidoRepository extends JpaRepository<PedidoEntity, Integer> {

//    @Query("SELECT p FROM PedidoEntity p WHERE p.status IN :status ORDER BY :status, p.dataCriacao")
    List<PedidoEntity> findByStatusInOrderByDataCriacaoAsc(List<StatusPedidoEntity> status);

}
