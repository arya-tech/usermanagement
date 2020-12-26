package com.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.um.service.UserServiceImpl;

@Controller
public class UnlockAccountController {
	
	@Autowired
	public UserServiceImpl userService;
	
	
	public String unlockAccount(String emailId,String tempPwd) {
		if(userService.isTempPwdValid(emailId, tempPwd)==true) {
			return userService.unlockAccount(emailId, tempPwd);
		}
		
		return "unable to unlock the account";
	}
	
}
