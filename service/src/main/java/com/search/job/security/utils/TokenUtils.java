package com.search.job.security.utils;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jyoti.yadav@globallogic.com
 */
public class TokenUtils {

	static Map<String, TokenHolderObject> tokens = new HashMap<String, TokenHolderObject>();

	public static synchronized String getToken(TokenHolderObject userDetails)  {
		
		try {
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");

			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();

			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(randomNum.getBytes());

			String token=  hexEncode(result);
			tokens.put(token, userDetails);
			
			return token;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String hexEncode(byte[] aInput) {
		StringBuilder result = new StringBuilder();
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		for (int idx = 0; idx < aInput.length; ++idx) {
			byte b = aInput[idx];
			result.append(digits[(b & 0xf0) >> 4]);
			result.append(digits[b & 0x0f]);
		}
		return result.toString();
	}

	public static boolean validate(String token) {
		return tokens.containsKey(token);
	}

	public static TokenHolderObject getUserFromToken(String token) {
		return tokens.get(token);
	}

	public static void removerToken(String token) {
		tokens.remove(token);
	}
}
