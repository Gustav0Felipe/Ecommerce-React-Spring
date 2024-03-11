package com.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.InputDto.LoginDto;
import com.api.Service.ClienteService;
import com.domain.model.Cliente;


@RequestMapping("/login")
@RestController
public class LoginController {

	@Autowired
	ClienteService clienteService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@Transactional
	@PostMapping
	public Cliente validarLogin(@RequestBody LoginDto clienteData) {
		return clienteService.login(clienteData);
		
	}
	
}
