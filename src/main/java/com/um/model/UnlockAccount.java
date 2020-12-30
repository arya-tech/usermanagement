package com.um.model;

public class UnlockAccount {
	
	private String emailId;
	private String tempPwd;
	private String newPwd;
	private String cnfNewPwd;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTempPwd() {
		return tempPwd;
	}
	public void setTempPwd(String tempPwd) {
		this.tempPwd = tempPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getCnfNewPwd() {
		return cnfNewPwd;
	}
	public void setCnfNewPwd(String cnfNewPwd) {
		this.cnfNewPwd = cnfNewPwd;
	}
	
	

}
