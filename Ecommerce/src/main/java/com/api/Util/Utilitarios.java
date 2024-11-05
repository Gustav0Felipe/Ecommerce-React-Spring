package com.api.Util;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

import com.domain.model.Credenciamento;
import com.domain.repository.CredenciamentoEmpresaRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Utilitarios {

	Credenciamento empresa;
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	Utilitarios(CredenciamentoEmpresaRepository credenciamentoRepository){
		empresa = credenciamentoRepository.findById(1).get();
	}
	
	public static String gerarStringAlphanumerica(int length) {
		SecureRandom secureRandom = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			int index = secureRandom.nextInt(CHARACTERS.length());
			sb.append(CHARACTERS.charAt(index));
		}
		
	    return sb.toString();
	}
}
