package com.isshelper.input;

public class IssHelperRiderSignUpInputVO {

	private String name;
	private long phone;
	private String email;
	private String driversLicense;
	private String password;
	private String university;

	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

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
				+ ", driversLicense=" + driversLicense + ", password=" + password + ", university=" + university + "]";
	}

}