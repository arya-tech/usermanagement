package com.um.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CITY_MASTER")
public class City {
	@Column(name="CITY_ID")
	protected Integer cityId;
	@Column(name = "CITY_NAME")
	protected String cityName;
	@Column(name = "STATE_ID")
	protected Integer stateId;
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	
}
