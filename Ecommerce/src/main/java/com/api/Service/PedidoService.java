package com.api.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.InputDto.CartItemDto;
import com.api.dto.InputDto.PedidoDto;
import com.domain.model.Produto;
import com.domain.repository.PedidoRepository;
import com.domain.repository.ProdutoRepository;

@Service
public class PedidoService {
	
	@Autowired 
	PedidoRepository pedidoRepository;

	@Autowired 
	ProdutoRepository produtoRepository;

	public Double calcularValorTotal(PedidoDto pedido) {
		Double valorTotal = 0d;
		for(CartItemDto produto : pedido.produtos()) {
		
			Optional<Produto> item = produtoRepository.findById(produto.id_prod());
			valorTotal = valorTotal + (item.get().getVal_prod() * produto.quantity()); //a quantidade pego do front end, o valor diretamente do banco de dados.
		
		}
		return valorTotal;
	}
	
	public void subirPedido(PedidoDto pedido) {
		int numeroPedido = pedidoRepository.pd_subir_encomenda(Integer.parseInt(pedido.clienteId()));
		
		for(CartItemDto produto : pedido.produtos()) {
			pedidoRepository.pd_subir_encomenda_itens(numeroPedido, produto.id_prod(), produto.quantity());
		}
	};
}
