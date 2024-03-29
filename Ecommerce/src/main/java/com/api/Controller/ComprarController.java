package com.api.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.Service.PedidoService;
import com.api.Service.PixService;
import com.api.dto.InputDto.PedidoDto;
import com.domain.model.Produto;
import com.domain.repository.ProdutoRepository;


@RestController
public class ComprarController  {
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	PixService pixService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/produto")
	public Produto buscarProduto(@RequestParam Integer id ) {
		Produto produto = new Produto();
		produto = produtoRepository.findById(id).orElse(null); 
		return produto;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/cart/subir-pedido")
	public ResponseEntity<String> finalizarPedido(@RequestBody PedidoDto pedido){
		System.out.println("Pedido Dto: " + pedido);
		Double valorTotal = pedidoService.calcularValorTotal(pedido);
		JSONObject response = pixService.pixCreateCharge(pedido , valorTotal);
		System.out.println("Resposta : " + response);
		
		if(response == null) {
			response = new JSONObject();
			response.put("Mensagem", "Pix não foi gerado.");
		}else {
			pedidoService.subirPedido(pedido);
		}
		return ResponseEntity.ok(response.toString());
	}
}
