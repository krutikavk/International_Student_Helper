package com.isshelper.pojo;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private String S_ID;
	private String S_Name;
	private String S_Email;
	private long S_Phone;
	private int S_University;
	private String S_Password;

	/**
	 * @return the s_ID
	 */
	public String getS_ID() {
		return S_ID;
	}

	/**
	 * @param s_ID the s_ID to set
	 */
	public void setS_ID(String s_ID) {
		S_ID = s_ID;
	}

	public String getS_Name() {
		return S_Name;
	}

	public void setS_Name(String s_Name) {
		S_Name = s_Name;
	}

	public String getS_Email() {
		return S_Email;
	}

	public void setS_Email(String s_Email) {
		S_Email = s_Email;
	}

	public long getS_Phone() {
		return S_Phone;
	}

	public void setS_Phone(long s_Phone) {
		S_Phone = s_Phone;
	}

	public int getS_University() {
		return S_University;
	}

	public void setS_University(int s_University) {
		S_University = s_University;
	}

	/**
	 * @return the s_Password
	 */
	public String getS_Password() {
		return S_Password;
	}

	/**
	 * @param s_Password the s_Password to set
	 */
	public void setS_Password(String s_Password) {
		S_Password = s_Password;
	}

	@Override
	public String toString() {
		return "Student [S_ID=" + S_ID + ", S_Name=" + S_Name + ", S_Email=" + S_Email + ", S_Phone=" + S_Phone
				+ ", S_University=" + S_University + ", S_Password=" + S_Password + "]";
	}

	
	 
	
}
