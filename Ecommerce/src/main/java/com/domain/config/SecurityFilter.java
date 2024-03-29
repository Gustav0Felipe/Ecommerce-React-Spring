package com.domain.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.Service.TokenService;
import com.domain.repository.ClienteRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;
	

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		var token = this.recoverToken(request);
		if(token != null) {
			var subject = tokenService.validarToken(token);
			UserDetails cliente = clienteRepository.findByEmail(subject);
			var authentication = new UsernamePasswordAuthenticationToken(cliente, null, cliente.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			
		}
		
		filterChain.doFilter(request, response);
	}

	private String recoverToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if(authHeader == null) {
			return null;
		} else {
			return authHeader.replace("Bearer ", "");
		}
	}
}
