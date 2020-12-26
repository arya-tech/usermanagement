package com.um.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		List<Country> listOfCountries=countryRepositories.findAll();
		Map<Integer, String> countries=new HashMap<>(); 
		listOfCountries.forEach(country->{
			countries.put(country.getCountryId(), country.getCountryName());
		});
		return countries;
	}

	@Override
	public Map<Integer, String> findByStates(Integer countryId) {
		List<State> listOfStates=stateRepositories.findCountryById(countryId);
		Map<Integer, String> states=new HashMap<>();
		listOfStates.forEach(state->{
			states.put(state.getStateId(), state.getStateName());
		});
		return states;
	}

	@Override
	public Map<Integer, String> findByCities(Integer stateId) {
		List<City> listOfCities=cityRepositories.findByStateId(stateId);
		Map<Integer, String> cities=new HashMap<>();
		listOfCities.forEach(city->{
			cities.put(city.getCityId(), city.getCityName());
		});
		return cities;
	}

	@Override
	public boolean isEmailUnique(String emailId) {
		
		User userDetails = userRepositories.findByEmail(emailId);
		String emailAvailaible=userDetails.getEmail();
		if(emailAvailaible!=null) {
			return true;
		}
		return false;
	}

	@Override
	public String saveUser(User user) {
		User savedUser = userRepositories.save(user);
		if(savedUser!=null) {
			return "user data saved successfully";
		}
		return "failed to save the user";
	}
	
	

	@Override
	public boolean isTempPwdValid(String emailId, String tempPwd) {
		tempPwd=userRepositories.findByPwd(emailId);
		if(tempPwd!=null) {
			return true;
		}
		return false;
	}

	@Override
	public String unlockAccount(String emailId, String newPwd) {
		return "account unlocked please sign up again";
	}

	@Override
	public String forgotPassword(String emailId) {
		//check the email is valid and present in databas then send the password by email link.
		return null;
	}

	@Override
	public String loginCheck(String emailId, String pwd) {
		String accountStatus=null;
		if(emailId!=null) {
			User userDetails=userRepositories.findByEmail(emailId);
			accountStatus=userDetails.getAccStatus();
			if(userDetails.getEmail().equals(emailId) && userDetails.getPwd().equals(pwd) && accountStatus=="UNLOCKED") {
				return "login successfull";
			}
		}
		return "failed to login check email id and password and make sure you unlock the account";
	}
	
	

}
