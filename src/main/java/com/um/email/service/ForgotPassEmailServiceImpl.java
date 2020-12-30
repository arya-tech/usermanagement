package com.um.email.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.entity.User;
import com.um.repositories.UserMasterRepositories;

@Service
public class ForgotPassEmailServiceImpl implements ForgotPasswordEmailService {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserMasterRepositories userRepository;
	
	@Override
	public String sendForgotPassMail(String emailId) {
		return emailService.sendEmail(emailId, "Recover Account Password", getForgotPasswordEmailBody(emailId));
	}
	
	@Override
	public String getForgotPasswordEmailBody(String emailId) {
			User userInfo = userRepository.findByEmail(emailId);
		String fileName="forgot-password.txt";
		List<String> replacedLines=null;
		String mailBody=null;
		try {
			Path path=Paths.get(fileName, "");
			Stream<String> lines= Files.lines(path);
			replacedLines=lines.map(line->line.replace("{firstname}", userInfo.getFirstName())
					.replace("{lastname}", userInfo.getLastName())
					.replace("{temp-pwd}", userInfo.getPwd())
					.replace("{email}", userInfo.getEmail())).collect(Collectors.toList());
			
			mailBody=String.join("", replacedLines);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mailBody;
	}

}
