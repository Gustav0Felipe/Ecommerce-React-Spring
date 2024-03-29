package com.api.Util;

import java.security.SecureRandom;

public class Utilitarios {
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
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
