package com;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.domain.model.Categoria;
import com.domain.model.Cliente;
import com.domain.model.Pedido;
import com.domain.model.Produto;
import com.domain.repository.ClienteRepository;
import com.domain.repository.PedidoProdutoRepository;
import com.domain.repository.PedidoRepository;
import com.domain.repository.ProdutoRepository;


@SpringBootTest
@ActiveProfiles("test")
class AdminServiceTests {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired 
	PedidoProdutoRepository pedidoProdutoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	@Test
	@DisplayName("Deve conseguir cadastrar o produto.")
	void cadastrarProdutoSucesso() {
		
		Categoria categoria = new Categoria(1, null);
		Produto produto = new Produto();
		
		produto.setNome_prod("Teste"); 
		produto.setDesc_prod("Produto de Teste"); 
		produto.setCusto_prod(1.0); 
		produto.setVal_prod(2.0); 
		produto.setQtd_estq(10); 
		produto.setCod_cat(categoria);
		produto.setImage("Imagem de Teste.");
		
		produto = produtoRepository.save(produto);
		
		Optional<Produto> result = Optional.ofNullable(this.produtoRepository.findById(produto.getId_prod()));
		produtoRepository.deleteById(result.get().getId_prod());
		assertThat(result.isPresent()).isTrue();
	}
	
	@Test
	@DisplayName("Deve conseguir finalizar um pedido pendente.")
	public void finalizarPedidoSucesso(){
		
		pedidoProdutoRepository.deleteAll();
		produtoRepository.deleteAll();
		pedidoRepository.deleteAll();
		clienteRepository.deleteAll();

		Integer pedido = subirPedido();
		
		pedidoProdutoRepository.pd_finalizar_encomenda(pedido);
		
		Optional<Pedido> result = pedidoRepository.findById(pedido);
		
		Assertions.assertEquals("finalizado", result.get().getStatus_ped());
	}

	private Integer subirPedido() {
		
		Cliente cliente = new Cliente(
				"Cliente de Teste",
				"911234567",
				"Teste@hotmail.com",
				"SenhaDeTeste",
				"123.123.123-12",
				"USER"
				);
		cliente.setVerificationCode(null);
		cliente.setEnabled(true);
		cliente.setRole("USER");
		cliente = clienteRepository.save(cliente);

		Produto produto = new Produto();
		Categoria categoria = new Categoria(1, null);
		produto.setNome_prod("Teste Subir Pedido"); 
		produto.setDesc_prod("Produto de Teste"); 
		produto.setCusto_prod(1.0); 
		produto.setVal_prod(2.0); 
		produto.setQtd_estq(10); 
		produto.setCod_cat(categoria);
		produto.setImage("Imagem de Teste.");
		produto = produtoRepository.save(produto);
		
		int numeroPedido = pedidoRepository.pd_subir_encomenda(cliente.getCod_cli());
		
		pedidoRepository.pd_subir_encomenda_itens(numeroPedido, produto.getId_prod(), 5);
		return numeroPedido;
	};
}
