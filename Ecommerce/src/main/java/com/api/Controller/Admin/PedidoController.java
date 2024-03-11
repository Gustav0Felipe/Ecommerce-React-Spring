package com.api.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.Service.AdminService;
import com.domain.model.Pedido;
import com.domain.model.PedidoProduto;

@RequestMapping("/admin")
@RestController
public class PedidoController {
	
	@Autowired
	AdminService adminService;
	
	@Transactional
	@GetMapping("/listar/pedidos")
	public List<Pedido> listarPedidos(){
		List<Pedido> pedidos = adminService.listarPedidos();
		return pedidos;
	}
	
	@Transactional
	@GetMapping("/listar/pedido")
	public List<PedidoProduto> detalharPedido(@RequestParam int pedido) {
		List<PedidoProduto> produtos = adminService.detalharPedido(pedido);
		return produtos;
	}
	
	@CrossOrigin(allowedHeaders = "*", origins = "*" )
	@PutMapping("/listar/pedido")
	public void finalizarPedido(@RequestParam int pedido){
		adminService.finalizarPedido(pedido);
	}
	
}
