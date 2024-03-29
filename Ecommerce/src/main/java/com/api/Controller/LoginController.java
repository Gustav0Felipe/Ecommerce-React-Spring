package com.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Service.ClienteService;
import com.api.Service.TokenService;
import com.api.dto.InputDto.LoginDto;
import com.api.dto.OutputDto.DadosClienteDto;
import com.domain.model.Cliente;


@RequestMapping("/login")
@RestController
public class LoginController {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	ClienteService clienteService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@Transactional
	@PostMapping
	public ResponseEntity<DadosClienteDto> validarLogin(@RequestBody LoginDto clienteData) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(clienteData.email(), clienteData.senha());
		
		var auth = authenticationManager.authenticate(usernamePassword);
		
		Cliente cliente = (Cliente) auth.getPrincipal();
		
		DadosClienteDto clienteResponse = null;
		if(cliente != null) {
			var token = tokenService.generateToken(cliente);
			clienteResponse = new DadosClienteDto(cliente.getCod_cli(), cliente.getNome(), cliente.getEmail(), 
				cliente.getPassword(), cliente.getTelefone(), cliente.getCpf(), token, cliente.getRole());
		}
		
		return ResponseEntity.ok(clienteResponse);
		
	}
	
}
