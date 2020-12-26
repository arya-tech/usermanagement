package com.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.um.entity.User;
import com.um.service.UserServiceImpl;

@Controller
public class RegistrationRestController {
	
	@Autowired
	public UserServiceImpl userService;
	
	@GetMapping("/loadRegForm")
	public String loadForm(Model model) {
		model.addAttribute("user", new User());
		return "regForm";
	}
	
	@PostMapping("/saveUserDetails")
	public String saveUserInfo(User userInfo, RedirectAttributes redirect) {
		String savedUser = userService.saveUser(userInfo);
		if(savedUser!=null) {
			return "user data saved successfully";
		}
		return "failed to save user data";
	}

}
