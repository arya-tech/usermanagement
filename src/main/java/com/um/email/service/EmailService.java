package com.um.email.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements IEmailServices {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendEmail(String to, String subject, String msgBody) {
		try {
			MimeMessage mimeMsg=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMsg);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(msgBody,true);
			javaMailSender.send(mimeMsg);
			return "email send successfully";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "failed to send an email";
	}
}
