package com.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.domain.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Procedure
	public int pd_subir_encomenda(int idCliente);

	@Procedure
	public void pd_subir_encomenda_itens(int Pedido, int CodProduto, int Quantidade);
	
	List<Pedido> findAll();

	@Procedure
	public List<Pedido> pd_emitir_relatorio(int ano, int mes);
}
