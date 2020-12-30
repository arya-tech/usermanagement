package com.um.email.service;

import com.um.entity.User;

public interface ForgotPasswordEmailService {
	
	public String sendForgotPassMail(String emailId);
	
	public String getForgotPasswordEmailBody(String emailId);

}
