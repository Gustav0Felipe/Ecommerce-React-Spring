package com.api.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.api.Util.Utilitarios;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.domain.model.Cliente;

@Service
public class TokenService {
	
	private String jwt_secret;
	
	private Utilitarios ultilitario;

	TokenService(Utilitarios ultilitario){
		this.ultilitario = ultilitario;
		jwt_secret = this.ultilitario.getEmpresa().getJwt_secret();
	}
	
	public String generateToken(Cliente cliente) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(jwt_secret);
			String token = JWT.create().withIssuer("auth")
					.withSubject(cliente.getEmail()).withExpiresAt(ExpirationDate()).sign(algorithm);
			return token;
		} catch  (JWTCreationException exception){
			throw new RuntimeException("ERRO: Token não foi gerado.", exception);
		}
	}

	public String validarToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(jwt_secret);
			return JWT.require(algorithm)
					.withIssuer("auth")
					.build()
					.verify(token)
					.getSubject();
					
		} catch (JWTVerificationException exception) {
			throw new RuntimeException("Token inválido", exception);
		}
	}
	
	private Instant ExpirationDate() {
		return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
	}
}
