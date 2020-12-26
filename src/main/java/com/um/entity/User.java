package com.um.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "USER_MASTER")
public class User {
	@Column(name = "FIRST_NAME")
	protected String firstName;
	@Column(name = "LAST_NAME")
	protected String lastName;
	@Column(name = "EMAIL")
	protected String email;
	@Column(name = "PHONE_NO")
	protected String phNo;
	@Column(name = "DOB")
	protected Date dob;
	@Column(name = "GENDER")
	protected String gender;
	@Column(name = "COUNTRY")
	protected String country;
	@Column(name = "STATE")
	protected String states;
	@Column(name = "CITY")
	protected String cities;
	@Column(name = "PWD")
	protected String pwd;
	@Column(name = "ACC_STATUS")
	protected String accStatus;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public String getCities() {
		return cities;
	}
	public void setCities(String cities) {
		this.cities = cities;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAccStatus() {
		return accStatus;
	}
	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}
	

}
