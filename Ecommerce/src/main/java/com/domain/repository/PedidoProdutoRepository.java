package com.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.domain.model.PedidoProduto;
import com.domain.model.PedidosProdutosId;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, PedidosProdutosId> {
	
	@Query("select p from PedidoProduto p where p.pedidosProdutosId.pedido.num_ped=:pedId")
	List<PedidoProduto> findAllByPedido(@Param("pedId")int pedId);

	@Procedure
	public void pd_finalizar_encomenda(Integer pedido);

}
