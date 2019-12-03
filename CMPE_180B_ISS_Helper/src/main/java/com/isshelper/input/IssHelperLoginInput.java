//SJSU CMPE 138 Fall2019 TEAM8

package com.isshelper.input;

public class IssHelperLoginInput {
	private String email;
	private String password;
	private String flag;

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
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "LoginInput [email=" + email + ", password=" + password + ", flag=" + flag + "]";
	}

}