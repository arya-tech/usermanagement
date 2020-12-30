package com.um.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.um.email.service.IEmailServices;
import com.um.entity.City;
import com.um.entity.Country;
import com.um.entity.State;
import com.um.entity.User;
import com.um.repositories.CityMasterRepositories;
import com.um.repositories.CountryMasterRepositories;
import com.um.repositories.StateMasterRepositories;
import com.um.repositories.UserMasterRepositories;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMasterRepositories userRepositories;

	@Autowired
	private CountryMasterRepositories countryRepositories;

	@Autowired
	private StateMasterRepositories stateRepositories;

	@Autowired
	private CityMasterRepositories cityRepositories;


	@Override
	public Map<Integer, String> findByCountries() {
		List<Country> listOfCountries = countryRepositories.findAll();
		Map<Integer, String> countries = new HashMap<>();
		listOfCountries.forEach(country -> {
			countries.put(country.getCountryId(), country.getCountryName());
		});
		return countries;
	}

	@Override
	public Map<Integer, String> findByStates(Integer countryId) {
		List<State> listOfStates = stateRepositories.findByCountryId(countryId);
		Map<Integer, String> states = new HashMap<>();
		listOfStates.forEach(state -> {
			states.put(state.getStateId(), state.getStateName());
		});
		return states;
	}

	@Override
	public Map<Integer, String> findByCities(Integer stateId) {
		List<City> listOfCities = cityRepositories.findByStateId(stateId);
		Map<Integer, String> cities = new HashMap<>();
		listOfCities.forEach(city -> {
			cities.put(city.getCityId(), city.getCityName());
		});
		return cities;
	}

	@Override
	public boolean isEmailUnique(String emailId) {

		User userDetails = userRepositories.findByEmail(emailId);
		if (userDetails == null) {
			return true;
		}
		return false;
	}

	public String generateRandomPassword(int len) {
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}
		return sb.toString();
	}

	@Override
	public String saveUser(User user) {
		user.setAccStatus("LOCKED");
		user.setPwd(generateRandomPassword(8));
		User savedUser = userRepositories.save(user);
		if (savedUser != null) {
			return "user data saved successfully";
		}
		return "failed to save the user";
	}

	@Override
	public boolean isTempPwdValid(String emailId, String tempPwd) {
		tempPwd = userRepositories.findByPwd(emailId);
		if (tempPwd != null) {
			return true;
		}
		return false;
	}

	@Override
	public String unlockAccount(String emailId, String newPwd) {
		User unlockUserAcc = userRepositories.findByEmail(emailId);
		unlockUserAcc.setAccStatus("UNLOCKED");
		userRepositories.save(unlockUserAcc);
		return "account unlocked please sign up again";
	}

	@Override
	public String forgotPassword(String emailId) {
		// check the email is valid and present in databas then send the password by
		// email link.
		return null;
	}

	@Override
	public String loginCheck(String emailId, String pwd) {
		String accountStatus = null;
		if (emailId != null) {
			User userDetails = userRepositories.findByEmail(emailId);
			accountStatus = userDetails.getAccStatus();
			if (userDetails.getEmail().equals(emailId) && userDetails.getPwd().equals(pwd)
					&& accountStatus == "UNLOCKED") {
				return "login successfull";
			}
		}
		return "failed to login check email id and password and make sure you unlock the account";
	}
	
	@Override
	public String getUnlockAccEmailBody(User user) {
		StringBuffer stringBuffer=new StringBuffer();
		try {
			File file=new File("unlock-account.txt");
			FileReader fileReader=new FileReader(file);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String line=bufferedReader.readLine();
			while(line!=null) {
				if(line.contains("{firstname}")) {
					line=line.replace("{firstname}", user.getFirstName());
				}
				if(line.contains("{lastname}")) {
					line=line.replace("{lastname}", user.getLastName());
				}
				if(line.contains("{temp-pwd}")) {
					line=line.replace("{temp-pwd}", user.getPwd());
				}
				if(line.contains("{email}")) {
					line=line.replace("{email}", user.getEmail());
				}
				stringBuffer.append(line);
				
				line=bufferedReader.readLine();
			}
			bufferedReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stringBuffer.toString();
	}

}
