package com.ht.util;

import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public final class AesEncrypter {
	private static Logger logger = Logger.getLogger(AesEncrypter.class);

	private Cipher ecipher = null;

	private Cipher dcipher = null;

	private static AesEncrypter AesEncrypter = null;

	AesEncrypter(String passPhrase) throws InvalidKeySpecException {
		try {
			byte[] KeyData = passPhrase.getBytes();
			SecretKeySpec key = new SecretKeySpec(KeyData, "AES");

			this.ecipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			this.dcipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			this.ecipher.init(1, key);
			this.dcipher.init(2, key);
		} catch (NoSuchPaddingException e) {
			logger.error(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
		} catch (InvalidKeyException e) {
			logger.error(e.getMessage());
		}
	}

	public String encrypt(String str) {
		try {
			byte[] utf8 = str.getBytes("UTF8");

			byte[] enc = this.ecipher.doFinal(utf8);

			return new BASE64Encoder().encode(enc);
		} catch (BadPaddingException e) {
			logger.error(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			logger.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public String decrypt(String str) {
		try {
			byte[] dec = new BASE64Decoder().decodeBuffer(str);

			byte[] utf8 = this.dcipher.doFinal(dec);

			return new String(utf8, "UTF8");
		} catch (BadPaddingException e) {
			logger.error(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			logger.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			AesEncrypter encrypter = new AesEncrypter(".-'/h2@cty#vw6&t");

			String encrypted = encrypter.encrypt("icareuser");

			String decrypted = encrypter.decrypt(encrypted);

			System.out.println(encrypted + "|" + decrypted);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static AesEncrypter getInstance() {
		if (AesEncrypter == null) {
			try {
				AesEncrypter = new AesEncrypter(".-'/h2@cty#vw6&t");
			} catch (InvalidKeySpecException e) {
				logger.error(new Object[] { e });
			}
		}
		return AesEncrypter;
	}
}