package com.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.InputDto.LoginDto;
import com.api.InputDto.ProdutoDto;
import com.domain.model.Pedido;
import com.domain.model.PedidoProduto;
import com.domain.repository.AdminRepository;
import com.domain.repository.PedidoProdutoRepository;
import com.domain.repository.PedidoRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PedidoProdutoRepository pedidoProdutoRepository;
	
	public Boolean accessAdminPage(LoginDto credenciais) {
		return adminRepository.pd_is_admin(credenciais.email(), credenciais.senha());
	}
	
	public void cadastrarProduto(ProdutoDto produto) {
		adminRepository.pd_cadastro_produto(produto.nome(), produto.desc(), Double.parseDouble(produto.custo())
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

	public List<Pedido> filtrarPedidos(int year, int month) {
		return pedidoRepository.pd_emitir_relatorio(year, month);
		
	}
}
