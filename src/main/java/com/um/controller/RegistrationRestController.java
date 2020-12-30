package com.um.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.um.entity.User;
import com.um.email.service.EmailService;
import com.um.service.UserServiceImpl;

@RestController
public class RegistrationRestController {
	
	@Autowired
	public UserServiceImpl userService;
	
	@Autowired
	public EmailService emailService;
	
	@GetMapping("/loadRegForm")
	public String loadForm(Model model) {
		model.addAttribute("user", new User());
		return "regForm";
	}
	
	@GetMapping(value="/getCountries")
	public Map<Integer, String> getAllCountries(){
		return  userService.findByCountries();
		
	}
	
	@GetMapping(value="/getStates/{countryId}")
	public Map<Integer,String> getAllStates(@PathVariable Integer countryId){
		return userService.findByStates(countryId);
	}
	
	@GetMapping(value="/getCities/{stateId}")
	public Map<Integer, String> getAllCities(@PathVariable Integer stateId){
		return userService.findByCities(stateId);
	}
	
	@GetMapping(value = "/emailCheck/{emailId}")
	public String isEmailUnique(@PathVariable String emailId) {
		if(userService.isEmailUnique(emailId)==true) {
			return "true";
		}
		return "false";
	}
	
	
	@PostMapping(value= "/registration", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> userRegistration(@RequestBody User userInfo) {
		if(userService.isEmailUnique(userInfo.getEmail())) {
		String savedUser = userService.saveUser(userInfo);
		if(savedUser!=null) {
			
			return new ResponseEntity<>("user registered successfully, please check your email to unlock the account", HttpStatus.CREATED);
		}
		}
		return new ResponseEntity<>("faild to register the user",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value="/login/{emailId}/{pwd}")
	public ResponseEntity<String> loginCheck(@PathVariable String emailId, @PathVariable String pwd){
		String loginCheckStatus = userService.loginCheck(emailId, pwd);
		if(loginCheckStatus!=null) {
			return new ResponseEntity<String>("Login success!!!!",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("username or password invalid",HttpStatus.BAD_REQUEST);
		
	}
}
