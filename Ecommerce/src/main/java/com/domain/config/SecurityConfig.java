package com.domain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired 
	private SecurityFilter securityFilter;
	
	@Bean 
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests( authorize -> authorize
						.requestMatchers(HttpMethod.GET ,"/").permitAll()
						.requestMatchers(HttpMethod.GET ,"/produto").permitAll()
						.requestMatchers(HttpMethod.POST,"/cadastro").permitAll()
						.requestMatchers(HttpMethod.GET ,"/cadastro/verificar").permitAll()
						.requestMatchers(HttpMethod.POST,"/login").permitAll()
						.requestMatchers(HttpMethod.POST,"/admin/cadastrar-produto").hasAnyAuthority("ADMIN")
						.requestMatchers(HttpMethod.GET ,"/admin/listar/pedidos").hasAnyAuthority("ADMIN")
						.requestMatchers(HttpMethod.GET ,"/admin/listar/pedido").hasAnyAuthority("ADMIN")
						.requestMatchers(HttpMethod.PUT ,"/admin/listar/pedido").hasAnyAuthority("ADMIN")	
						.anyRequest().authenticated()
						).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).build();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
