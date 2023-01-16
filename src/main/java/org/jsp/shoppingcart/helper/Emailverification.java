package org.jsp.shoppingcart.helper;

import java.io.UnsupportedEncodingException;

import org.jsp.shoppingcart.dto.Customer;
import org.jsp.shoppingcart.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class Emailverification 
{
	@Autowired
	JavaMailSender mailSender;
	
	public void sendVerification(Merchant merchant)
	{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
	
		try {
			helper.setFrom("saishkulkarni7@gmail.com","Shopping-cart");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			helper.setTo(merchant.getEmail());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			helper.setSubject("Email verification");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			helper.setText("Hello "+merchant.getName()+" below is the otp for your account creation "+merchant.getOtp());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mailSender.send(mimeMessage);
		
	}
	
	public void sendVerification(Customer customer)
	{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
	
		try {
			helper.setFrom("saishkulkarni7@gmail.com","Shopping-cart");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			helper.setTo(customer.getEmail());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			helper.setSubject("Email verification");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			helper.setText("Hello "+customer.getName()+" below is the otp for your account creation "+customer.getOtp());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mailSender.send(mimeMessage);
		
	}
}
