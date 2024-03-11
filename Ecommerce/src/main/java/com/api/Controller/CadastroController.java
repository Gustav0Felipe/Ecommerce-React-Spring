package com.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.InputDto.ClienteDto;
import com.api.Service.ClienteService;
import com.domain.model.Cliente;

@RequestMapping("/cadastro")
@RestController
public class CadastroController {
	
	@Autowired
	ClienteService clienteService;
	
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public Cliente cadastrarCliente(@RequestBody ClienteDto cadastro) {
		
		Boolean clientExistent = clienteService.clienteJaCadastrado(cadastro.email(), cadastro.cpf());
		if(!clientExistent) {
		return clienteService.cadastrarCliente(cadastro);
		}else {
			return null;
		}
	}
}
