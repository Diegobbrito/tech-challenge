package br.com.fiap.lanchonete.gateway.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaPedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    @Query(""" 
            SELECT p FROM PedidoEntity p
            WHERE p.status IN :statuses
            ORDER BY p.status.id DESC, p.dataCriacao ASC
            """)
    List<PedidoEntity> findByStatusInOrderByDataCriacaoAsc( @Param("statuses") List<StatusPedidoEntity> statuses);


}
