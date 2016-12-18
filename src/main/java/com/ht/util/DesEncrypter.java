package com.ht.util;

import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public final class DesEncrypter {
	private static Logger logger = Logger.getLogger(DesEncrypter.class);

	private Cipher ecipher = null;

	private Cipher dcipher = null;

	private static DesEncrypter desEncrypter = null;

	DesEncrypter(String passPhrase) {
		try {
			KeySpec keySpec = new DESKeySpec(passPhrase.getBytes());
			SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(
					keySpec);

			this.ecipher = Cipher.getInstance("DES");
			this.dcipher = Cipher.getInstance("DES");

			this.ecipher.init(1, key);
			this.dcipher.init(2, key);
		} catch (NoSuchPaddingException e) {
			logger.error(new Object[] { e });
		} catch (NoSuchAlgorithmException e) {
			logger.error(new Object[] { e });
		} catch (InvalidKeyException e) {
			logger.error(new Object[] { e });
		} catch (InvalidKeySpecException e) {
			logger.error(new Object[] { e });
		}
	}

	public String encrypt(String str) {
		try {
			byte[] utf8 = str.getBytes("UTF8");

			byte[] enc = this.ecipher.doFinal(utf8);

			return new BASE64Encoder().encode(enc);
		} catch (BadPaddingException e) {
			logger.error(new Object[] { e });
		} catch (IllegalBlockSizeException e) {
			logger.error(new Object[] { e });
		} catch (UnsupportedEncodingException e) {
			logger.error(new Object[] { e });
		}
		return null;
	}

	public String decrypt(String str) {
		try {
			byte[] dec = new BASE64Decoder().decodeBuffer(str);

			byte[] utf8 = this.dcipher.doFinal(dec);

			return new String(utf8, "UTF8");
		} catch (BadPaddingException e) {
			logger.error(new Object[] { e });
		} catch (IllegalBlockSizeException e) {
			logger.error(new Object[] { e });
		} catch (UnsupportedEncodingException e) {
			logger.error(new Object[] { e });
		} catch (IOException e) {
			logger.error(new Object[] { e });
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			DesEncrypter encrypter = new DesEncrypter(".-'/W2@cty#vw6&HTxa55");

			String encrypted = encrypter.encrypt("icareuser");

			String decrypted = encrypter.decrypt(encrypted);

			System.out.println(encrypted + "|" + decrypted);
		} catch (Exception e) {
		}
	}

	public static DesEncrypter getInstance() {
		if (desEncrypter == null) {
			desEncrypter = new DesEncrypter(".-'/W2@cty#vw6&HTxa");
		}
		return desEncrypter;
	}
}