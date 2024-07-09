package com.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.InputDto.ProdutoDto;
import com.domain.model.Pedido;
import com.domain.model.PedidoProduto;
import com.domain.repository.PedidoProdutoRepository;
import com.domain.repository.PedidoRepository;
import com.domain.repository.ProdutoRepository;

@Service
public class AdminService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PedidoProdutoRepository pedidoProdutoRepository;
	
	
	
	public void cadastrarProduto(ProdutoDto produto) {
		produtoRepository.pd_cadastro_produto(produto.nome(), produto.desc(), Double.parseDouble(produto.custo())
				, Double.parseDouble(produto.valor()), Integer.parseInt(produto.estoque())
				, Integer.parseInt(produto.categoria()), produto.imagem());
	}

	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}
	
	public List<PedidoProduto> detalharPedido(int pedido){
		return pedidoProdutoRepository.findAllByPedido(pedido);
	}
  	public void finalizarPedido(int pedido){
		pedidoProdutoRepository.pd_finalizar_encomenda(pedido);
		
	}

	//Atualmente a filtragem esta sendo feita no FrontEnd.
	public List<Pedido> filtrarPedidos(int year, int month) {
		return pedidoRepository.pd_emitir_relatorio(year, month);
		
	}
}
