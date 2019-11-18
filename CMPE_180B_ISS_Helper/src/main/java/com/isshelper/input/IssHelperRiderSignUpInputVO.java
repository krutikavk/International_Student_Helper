package com.isshelper.input;

public class IssHelperRiderSignUpInputVO {
	
	private String name;
	private long phone;
	private String email;
	private String driversLicense;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the phone
	 */
	public long getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the driversLicense
	 */
	public String getDriversLicense() {
		return driversLicense;
	}
	/**
	 * @param driversLicense the driversLicense to set
	 */
	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense;
	}
	@Override
	public String toString() {
		return "IssHelperRiderSignUpInputVO [name=" + name + ", phone=" + phone + ", email=" + email
				+ ", driversLicense=" + driversLicense + "]";
	}
	
}