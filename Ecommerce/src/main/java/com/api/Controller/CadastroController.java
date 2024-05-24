package com.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.Service.ClienteService;
import com.api.dto.InputDto.CadastroClienteDto;
import com.api.dto.OutputDto.DadosClienteDto;
import com.domain.model.Cliente;

import jakarta.validation.Valid;

@RequestMapping("/cadastro")
@RestController
public class CadastroController {
	
	@Autowired
	ClienteService clienteService;
	
	@Transactional
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public ResponseEntity<DadosClienteDto> cadastrarCliente(@RequestBody @Valid CadastroClienteDto cadastro) {
		Cliente cliente = cadastro.toModel();
		
		DadosClienteDto clienteSalvo =  clienteService.cadastrarCliente(cliente);
		return ResponseEntity.ok().body(clienteSalvo);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/verificar")
	public Boolean verificarUsuario(@RequestParam String code) {
		if(clienteService.verify(code)) {
			return true;
		} else {
			return false;
		}
	}
	
}
