package com.api.Util;

import java.util.Random;

public class Utilitarios {
	public static String gerarStringAlphanumerica() {

		int leftLimit = 48; // numero '0'
	    int rightLimit = 122; // letra 'z'
	    int targetStringLength = 20;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}
}
