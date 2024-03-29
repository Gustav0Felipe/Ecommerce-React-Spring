package com.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.Service.ClienteService;
import com.api.Service.TokenService;
import com.api.dto.InputDto.AtualizarClienteDto;
import com.api.dto.InputDto.AtualizarClienteSenhaDto;
import com.api.dto.OutputDto.DadosClienteDto;
import com.domain.model.Cliente;

import jakarta.validation.Valid;

@RequestMapping("/perfil")
@RestController
public class PerfilController {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	TokenService tokenService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/autenticar-senha")
	public String autenticarSenha(@RequestBody AtualizarClienteSenhaDto cliente) {
		String token = clienteService.notificarCliente(cliente);
		if(token != null) {
			return token;
		}else {
			return null;
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/editar-senha")
	public Cliente editarSenha(@RequestBody AtualizarClienteSenhaDto dadosCliente) {
		return clienteService.atualizarSenhaCliente(dadosCliente);
	}
	
	@PreAuthorize("hasRole('ADMIN')") 
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@Transactional
	@PutMapping("/editar")
	public DadosClienteDto atualizarDados(@RequestBody @Valid AtualizarClienteDto dadosCliente ) {	
		
		Cliente cliente = clienteService.atualizarCliente(dadosCliente);
		return new DadosClienteDto(cliente.getCod_cli(), cliente.getNome(), cliente.getEmail(), 
				cliente.getPassword(), cliente.getTelefone(), cliente.getCpf(), dadosCliente.token(), cliente.getRole());
	} 
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deletar")
	public void deletarCliente(@RequestParam String idCliente) {
		clienteService.deletarCliente(idCliente);
	}
	
}
