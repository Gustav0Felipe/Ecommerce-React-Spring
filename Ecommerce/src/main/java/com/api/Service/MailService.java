package com.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.api.dto.InputDto.AtualizarClienteSenhaDto;
import com.domain.model.Cliente;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	@Autowired
    private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String remetente;
	
	private String verifyURL = "http://localhost:5173/loja";
	
	public void sendPassChangeEmail(String token, AtualizarClienteSenhaDto cliente) {
		try {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		String htmlMsg = 
			("<h1>Aviso!: Tentaram alterar a senha de sua conta no site Ecommerce</h1>"
			+ "<p>Se for o dono da conta, [[NOME]] , e não for aquele que efetuou o pedido, entre em contato, caso tenha efetuado o pedido: </p>"
			+ "<a href='%s/perfil/editar-senha/auth=%s'>Para prosseguir e alterar sua senha clique aqui.<a>".formatted(verifyURL, token)
			).replace("[[NOME]]", cliente.nome());
		helper.setText(htmlMsg, true);
		helper.setFrom(remetente);
		helper.setTo(cliente.email());
		helper.setSubject("Aviso de tentativa de alteração de senha.");
		mailSender.send(mimeMessage);
     	}catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
    }

	public void sendVerificationEmail(Cliente cliente) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
			String htmlMsg = 
				("<h1>Olá [[NOME]], aqui esta o link para confirmar seu cadastro: </h1>"
				+ String.format("<a href='%s/login/auth=%s'>Clique Aqui</a>", verifyURL, cliente.getVerificationCode())
				).replace("[[NOME]]", cliente.getNome());
			
			helper.setText(htmlMsg, true);
			helper.setFrom(remetente);
			helper.setTo(cliente.getEmail());
			helper.setSubject("Confirmação de registro.");
			mailSender.send(mimeMessage);
	     	}catch(Exception e) {
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
	     	}
		
	}
}
