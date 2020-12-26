package com.um.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.entity.City;

@Repository
public interface CityMasterRepositories extends JpaRepository<City, Serializable> {
	
	public List<City> findByStateId(Integer stateId);
	

}
