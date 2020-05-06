package com.multai.vip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multai.vip.bean.Address;
import com.multai.vip.bean.Order;
import com.multai.vip.dao.IAddressDAO;
import com.multai.vip.dao.IOrderDAO;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class OrderService implements IOrderService {

	@Autowired
	IOrderDAO orderDao;
	
	@Autowired
	IAddressDAO addressDao;

	@Override
	public Order getOrderByOrderId(Long orderId) {
		return orderDao.findByOrderId(orderId);
	}

	@Override
	public List<Order> getAllOrderByUserId(int userId) {
		return orderDao.findAllByUserId(userId);
	}

	@Override
	public List<Order> getAll() {
		return orderDao.findAll();
	}

	@Override
	public void addOrder(Order order) {
		sendMail(order);
		orderDao.save(order);
	}
	
	@Override
	public void updateOrder(Order order) {
		orderDao.saveAndFlush(order);
	}
	
	
	private void sendMail(Order order)
	{
		Address address= new Address();
        address= addressDao.findByAddressId(order.getAddressId());
		String text="";
		
		text="Hi"+"\n"+"\n"+"Order Placed"+"\n"+"\n"+"Customer : "+address.getUser()+"\n"+"Item Name : "+order.getItemName()+"\n"
		+"Address First Line: "+address.getAddressFirstField()+"\n"+"Address Second Line: "+address.getAddressSecoundField()+"\n"+"Landmark :"+
		address.getLandmark()+"\n"+"City : "+address.getCity()+"\n"+
				"State : "+address.getState()+"\n"+"Zip : "+address.getZip()+"\n"+"Mobile : "+address.getMobile()+"\n"+"\n"+"Thanks & Regards,"+"\n"+"VIP Tapti Food";
		System.out.println(text);
		
		String cc = order.getRestMailId();
		
		String to = order.getEmail();
		
		getMail(text,to,cc,order.getInvoiceId(),"Order Update - ");

    }

	@Override
	public void updateStatus(Long orderId, String invoiceId, String email, String restMailId, String status) {
		
		String text="";
		
		text="Hi"+"\n"+"\n"+"Order Cancelled"+"\n"+"\n"+"Thanks & Regards,"+"\n"+"VIP Tapti Food";
		System.out.println(text);
		getMail(text, email,restMailId, invoiceId,"Order Update - ");
		Order order= new Order();
		order = orderDao.findByInvoiceId(invoiceId);
		System.out.println("status");
		order.setStatus(status);
		orderDao.saveAndFlush(order);
	}
	
	private void getMail(String text, String to, String cc, String invoiceId, String subject)
	{
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
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(cc));

            // Set Subject: header field
            message.setSubject(subject+invoiceId);

            
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
}
