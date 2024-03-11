package com.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.EmailSender.EmailSender;
import com.api.InputDto.ClienteDto;
import com.api.InputDto.LoginDto;
import com.api.Service.ClienteService;
import com.domain.model.Cliente;

@RequestMapping("/perfil")
@RestController
public class PerfilController {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	EmailSender emailSender;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/autenticar-senha")
	public String autenticarSenha(@RequestBody LoginDto cliente) {
		String token = clienteService.notificarCliente(cliente);
		if(token != null) {
			return token;
		}else {
			return null;
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/editar-senha")
	public Cliente editarSenha(@RequestBody LoginDto dadosCliente) {
		return clienteService.atualizarSenhaCliente(dadosCliente);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@Transactional
	@PutMapping("/editar")
	public Cliente atualizarDados(@RequestBody ClienteDto dadosCliente ) {		
		return clienteService.atualizarCliente(dadosCliente);
		
	} 
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deletar")
	public void deletarCliente(@RequestParam String idCliente) {
		clienteService.deletarCliente(idCliente);
	}
	
}
