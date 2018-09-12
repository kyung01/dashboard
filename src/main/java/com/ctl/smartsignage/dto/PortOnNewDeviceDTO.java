package com.ctl.smartsignage.dto;

/**
 * @author Shivansh Bhatnagar
 */
public class PortOnNewDeviceDTO 
{
	private String previousPhoneNumber;
	private String newPhoneNumber;
	private String email;
	private String password;
	/**
	 * 
	 * @return previousPhoneNumber
	 */
	public String getPreviousPhoneNumber() {
		return previousPhoneNumber;
	}
	/**
	 * 
	 * @param previousPhoneNumber
	 */
	public void setPreviousPhoneNumber(String previousPhoneNumber) {
		this.previousPhoneNumber = previousPhoneNumber;
	}
	/**
	 * 
	 * @return newPhoneNumber
	 */
	public String getNewPhoneNumber() {
		return newPhoneNumber;
	}
	/**
	 * 
	 * @param newPhoneNumber
	 */
	public void setNewPhoneNumber(String newPhoneNumber) {
		this.newPhoneNumber = newPhoneNumber;
	}
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
