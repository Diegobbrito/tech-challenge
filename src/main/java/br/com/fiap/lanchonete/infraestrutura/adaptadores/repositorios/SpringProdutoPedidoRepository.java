package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositorios;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringProdutoPedidoRepository extends JpaRepository<ProdutoPedidoEntity, Integer> {
}
