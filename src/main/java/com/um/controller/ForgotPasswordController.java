package com.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.um.email.service.ForgotPassEmailServiceImpl;

@RestController
public class ForgotPasswordController {
	
	@Autowired
	public ForgotPassEmailServiceImpl forgotPwdService;
	
	@PostMapping(value="/sendForgotPwd/{emailId}")
	public ResponseEntity<String> sendForgotPwd(@PathVariable String emailId){
		forgotPwdService.sendForgotPassMail(emailId);
		return new ResponseEntity<String>("password send successfully to your registered email",HttpStatus.CREATED);
	}

}
