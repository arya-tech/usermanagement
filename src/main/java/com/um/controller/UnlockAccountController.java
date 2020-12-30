package com.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.um.entity.User;
import com.um.model.UnlockAccount;
import com.um.repositories.UserMasterRepositories;
import com.um.service.UserServiceImpl;

@Controller
public class UnlockAccountController {
	
	@Autowired
	public UserServiceImpl userService;
	
	@Autowired
	public UserMasterRepositories userRepositories;
	
	@PostMapping(value="/unlockAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> unlockAccount(@RequestBody UnlockAccount unlockAccount) {
		String msg = userService.unlockAccount(unlockAccount);
		if(msg!=null) {
			return new ResponseEntity<String>("account unlocked sign up",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("unable to unlock the account",HttpStatus.BAD_REQUEST);
	}
	
}
