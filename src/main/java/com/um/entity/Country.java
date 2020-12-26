package com.um.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY_MASTER")
public class Country {
	@Column(name = "COUNTRY_ID")
	protected Integer countryId;
	@Column(name = "COUNTRY_NAME")
	protected String countryName;
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	

}
