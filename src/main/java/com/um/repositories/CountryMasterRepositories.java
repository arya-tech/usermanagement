package com.um.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.um.entity.Country;

@Repository
public interface CountryMasterRepositories extends JpaRepository<Country, Serializable> {

}
