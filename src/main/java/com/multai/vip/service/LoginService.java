package com.multai.vip.service;

import com.multai.vip.bean.Person;
import com.multai.vip.dao.ILoginDAO;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class LoginService implements ILoginService {
	@Autowired
	ILoginDAO loginDao;

	public Person getUserById(int userId) {
		return this.loginDao.findByUserId(userId);
	}

	public int saveUser(Person person) {
		this.loginDao.save(person);
		int userId = ((Person) this.loginDao.findAll().get(this.loginDao.findAll().size() - 1)).getUserId();
		System.out.println(userId);
		return userId;
	}

	public List<Person> getAllUsers() {
		return this.loginDao.findAll();
	}

	public void setTemporaryPassword(String email, String passwordFromUi) {
		Person person = new Person();
		person = loginDao.findByEmail(email);
		String password = "";
		if (passwordFromUi == "00123temp00") {
			int i = (int) (new Date().getTime() / 10000);
			password = i + person.getUserId() + "vip";
			person.setPassword(password);
		} else {
			person.setPassword(passwordFromUi);
		}
		String text = "";
		text = "Hi" + "\n" + "\n" + "Password Updated" + "\n" + "Password is: " + password +"\n"+"Please change password this is just a temporary password"+"\n"+ "\n" + "\n"
				+ "Thanks & Regards," + "\n" + "VIP Tapti Food";
		getMail(text, email, "Forget Password");
		loginDao.saveAndFlush(person);
	}

	private void getMail(String text, String to, String subject) {
		// Recipient's email ID needs to be mentioned.

		// Sender's email ID needs to be mentioned
		String from = "viptaptifood@gmail.com";

		// Assuming you are sending email from through gmails smtp
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("viptaptifood@gmail.com", "VIP@1989");

			}

		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message

			message.setText(text);

			System.out.println("sending...");
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	@Override
	public void updateUser(Person person) {
		loginDao.saveAndFlush(person);
	}

	@Override
	public void deleteByUserId(int userId) {
		loginDao.deleteById(userId);
	}
}
