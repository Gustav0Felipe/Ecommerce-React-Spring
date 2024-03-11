package com.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.InputDto.CartItemDto;
import com.api.InputDto.PedidoDto;
import com.domain.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired 
	public PedidoRepository pedidoRepository;
	
	public void subirPedido(PedidoDto pedido) {
		int numeroPedido = pedidoRepository.pd_subir_encomenda(Integer.parseInt(pedido.Cliente()));
		
		for(CartItemDto produto : pedido.Produtos()) {
			pedidoRepository.pd_subir_encomenda_itens(numeroPedido, produto.id_prod(), produto.quantity());
		}
	};
}
