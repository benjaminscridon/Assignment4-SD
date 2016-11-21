package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import util.ReadPropertyFile;

import java.util.Properties;

/**
 * @author UTCN
 * @author Beniamin Scridon
 * @since 11/21/2016
 *
 */
public class MailService {
	private String username;
	private String password;
	private Properties props;

	/**
	 * Builds a mail service class, used for sending e-mails. The credentials
	 * provided should be the ones needed to autenthicate to the SMTP server
	 * (GMail by default).
	 *
	 * @param username
	 *            username to log in to the smtp server
	 * @param password
	 *            password to log in to the smtp server
	 */
	public MailService(ReadPropertyFile readPropertyFile) {
		this.username = readPropertyFile.getProperty("username");
		this.password = readPropertyFile.getProperty("password");

		props = new Properties();
		props.put("mail.smtp.auth", readPropertyFile.getProperty("mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable", readPropertyFile.getProperty("mail.smtp.starttls.enable"));
		props.put("mail.smtp.host", readPropertyFile.getProperty("mail.smtp.host"));
		props.put("mail.smtp.port", readPropertyFile.getProperty("mail.smtp.port"));
	}

	/**
	 * Sends an email with the subject and content specified, to the address
	 * specified.
	 *
	 * @param to
	 *            address to send email to
	 * @param subject
	 *            subject of the email
	 * @param content
	 *            content of the email
	 */
	public void sendMail(String to, String subject, String content) {
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);

			System.out.println("Mail sent to '" + to + "'.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}