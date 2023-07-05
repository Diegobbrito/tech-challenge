package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringPedidoRepository extends JpaRepository<PedidoEntity, Integer> {

}
