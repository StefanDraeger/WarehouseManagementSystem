package de.draegerit.wms.mailer;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailServiceImpl implements MailService {

	@Override
	public void sendMail(String empfaenger, String betreff, String nachricht, File... anhaenge) throws IOException {
		String to = empfaenger;
		String from = "stefandraeger1980@gmail.com";
		String pw = "xppupxtkvbyfdavv";
		// String pw = "Delphiking1980#12";
		String host = "smtp.googlemail.com";

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);

		properties.setProperty("mail.smtp.port", "465");

		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		properties.setProperty("mail.smtp.user", from);
		properties.setProperty("mail.smtp.password", pw);

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pw);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(betreff);
			message.setText(nachricht);

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(nachricht);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			if (anhaenge != null && anhaenge.length > 0) {
				for (File f : anhaenge) {
					MimeBodyPart attachPart = new MimeBodyPart();
					attachPart.attachFile(f);
					multipart.addBodyPart(attachPart);				}
			}
			
			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
