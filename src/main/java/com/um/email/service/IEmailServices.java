package com.um.email.service;

public interface IEmailServices {
	public String sendEmail(String to, String subject, String msgBody);
}
