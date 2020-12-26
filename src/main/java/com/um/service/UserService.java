package com.um.service;

import java.util.Map;

import com.um.entity.User;

public interface UserService {
	
	public Map<Integer, String> findByCountries();
	
	public Map<Integer, String> findByStates(Integer countryId);
	
	public Map<Integer, String> findByCities(Integer stateId);
	
	public boolean isEmailUnique(String emailId);
	
	public String saveUser(User user);
	
	public boolean isTempPwdValid(String emailId, String tempPwd);
	
	public String unlockAccount(String emailId, String newPwd);
	
	public String forgotPassword(String emailId);
	
	
	public String loginCheck(String emailId, String pwd);
	

}
