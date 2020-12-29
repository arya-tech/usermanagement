package com.um.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Autowired(required = false)
	private JavaMailSender javaMailSender;
	
	public String sendEmail(String to, String subject, String msgBody) {
		try {
			SimpleMailMessage smMsg=new SimpleMailMessage();
			smMsg.setTo(to);
			smMsg.setSubject(subject);
			smMsg.setText(msgBody);
			javaMailSender.send(smMsg);
			return "email send successfully";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "failed to send an email";
	}
}
