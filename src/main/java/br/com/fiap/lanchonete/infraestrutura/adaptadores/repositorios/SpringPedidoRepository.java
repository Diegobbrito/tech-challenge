package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.PedidoEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.StatusPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringPedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    List<PedidoEntity> findByStatusIn(List<StatusPedidoEntity> ids);

}
