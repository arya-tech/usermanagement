package com.um.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STATE_MASTER")
public class State {
	@Column(name = "STATE_ID")
	protected Integer stateId;
	@Column(name = "STATE_NAME")
	protected String stateName;
	@Column(name = "COUNTRY_ID")
	protected Integer countryId;
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	

}
