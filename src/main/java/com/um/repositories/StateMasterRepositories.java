package com.um.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.entity.State;

@Repository
public interface StateMasterRepositories extends JpaRepository<State, Serializable> {
	
	public List<State> findCountryById(Integer countryId);

}
