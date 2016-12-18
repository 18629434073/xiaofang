package com.ht.util;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

import javax.mail.Message.RecipientType;

/**
 * Demonstration program for the Simple Java Mail framework.
 * <p>
 * <b>IMPORTANT</b>: <br>
 * This testclass was designed to run from the commandline (or by Ant) and expects some device properties to be present. See
 * <b>Readme.txt</b> for instructions. Alternatively, you can assign the host, username and password a hard value and ignore the device
 * properties altogether.
 * 
 * @author
 */
public class MailUtil {
	
	private static String host = InitParamUtil.getProperty("mail_host");
	private static int port = Integer.parseInt(InitParamUtil.getProperty("mail_port"));
	private static String username = InitParamUtil.getProperty("mail_username");
	private static String password = InitParamUtil.getProperty("mail_password");

	public static void main(final String[] args) {
//		Email email = new Email();
		
//		email.setFromAddress("chenhao1", "erdongritian@163.com");
//		email.addRecipient("C.Cane", "erdongritian@foxmail.com", RecipientType.TO);
//		email.setText("We should meet up!sssssdd");
//		email.setTextHTML("We should meet up!");
//		email.setSubject("hey���");
		
		sendMail("erdongritian@foxmail.com","We should meet up!tttttttttggggggggg");
//		sendMail("erdongritian@foxmail.com","ddddddd");
	}

	public static void sendMail(String emailAddr,String mes) {
		Email email = new Email();
		
		email.setFromAddress("icare", username);
		email.addRecipient("service", emailAddr, RecipientType.TO);
//		email.setText(mes);
		email.setTextHTML(mes);
		email.setSubject("Auth Code");
		
		
//		final String host = "smtp.163.com";
//		final int port = 25;
//		final String username = "erdongritian@163.com";
//		final String password ="yixvhzbxxfpltcyj";
		
		new Mailer(host, port, username, password, TransportStrategy.SMTP_PLAIN).sendMail(email);
	}
}