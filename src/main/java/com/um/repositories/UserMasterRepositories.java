package com.um.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.um.entity.User;

@Repository
public interface UserMasterRepositories extends JpaRepository<User, Serializable> {
	
	public User findByEmail(String emailId);
	
	public String findByPwd(String emailId);

}
