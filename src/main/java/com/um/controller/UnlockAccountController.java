package com.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.um.entity.User;
import com.um.repositories.UserMasterRepositories;
import com.um.service.UserServiceImpl;

@Controller
public class UnlockAccountController {
	
	@Autowired
	public UserServiceImpl userService;
	
	@Autowired
	public UserMasterRepositories userRepositories;
	
	@PostMapping
	public String unlockAccount(String emailId,String tempPwd) {
		if(userService.isTempPwdValid(emailId, tempPwd)==true) {
			User userInfo = userRepositories.findByEmail(emailId);
			userInfo.setAccStatus("UNLOCKED");
			userRepositories.save(userInfo);
			return userService.unlockAccount(emailId, tempPwd);
		}
		
		return "unable to unlock the account";
	}
	
}
