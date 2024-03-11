package com.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.InputDto.PedidoDto;
import com.api.Service.PedidoService;

@RestController
@RequestMapping("/cart/subir-pedido")
public class FazerPedidoController {	
	
	@Autowired
	public PedidoService pedidoService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void FinalizarPedido(@RequestBody PedidoDto pedido){
		pedidoService.subirPedido(pedido);
	}
	
	
}
