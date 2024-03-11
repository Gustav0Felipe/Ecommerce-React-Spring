package com.api.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSender {

	@Autowired
    private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String remetente;
	
	public void sendEmail(String token, String destinatario) {
		try {
			

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		String htmlMsg = 
			("<h1>Aviso!: Tentaram alterar a senha de sua conta no site Ecommerce</h1>"
			+ "<p>Se for o dono da conta e não for aquele que efetuou o pedido, entre em contato, caso tenha efetuado o pedido: </p>"
			+ String.format("<a href='http://192.168.100.16:5173/loja/perfil/editar-senha/auth=%s'>Para prosseguir e alterar sua senha clique aqui.<a>", token)
			);
		helper.setText(htmlMsg, true);
		helper.setFrom(remetente);
		helper.setTo(destinatario);
		helper.setSubject("Aviso de tentativa de alteração de senha.");
		mailSender.send(mimeMessage);
     	}catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
    }

}
