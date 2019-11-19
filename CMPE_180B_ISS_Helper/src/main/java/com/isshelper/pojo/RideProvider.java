package com.isshelper.pojo;

import org.springframework.stereotype.Component;

@Component
public class RideProvider {

	private int P_Id;
	private String P_Name;
	private long P_Phone;
	private String P_Email;
	private String P_Drivers_License;
	private int P_University;
	private String P_Password;
	
	

	/**
	 * @return the p_University
	 */
	public int getP_University() {
		return P_University;
	}

	/**
	 * @param p_University the p_University to set
	 */
	public void setP_University(int p_University) {
		P_University = p_University;
	}

	public int getP_Id() {
		return P_Id;
	}

	public void setP_Id(int p_Id) {
		P_Id = p_Id;
	}

	public String getP_Name() {
		return P_Name;
	}

	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}

	public long getP_Phone() {
		return P_Phone;
	}

	public void setP_Phone(long p_Phone) {
		P_Phone = p_Phone;
	}

	public String getP_Email() {
		return P_Email;
	}

	public void setP_Email(String p_Email) {
		P_Email = p_Email;
	}

	public String getP_Drivers_License() {
		return P_Drivers_License;
	}

	public void setP_Drivers_License(String p_Drivers_License) {
		P_Drivers_License = p_Drivers_License;
	}

	/**
	 * @return the p_Password
	 */
	public String getP_Password() {
		return P_Password;
	}

	/**
	 * @param p_Password the p_Password to set
	 */
	public void setP_Password(String p_Password) {
		P_Password = p_Password;
	}

	@Override
	public String toString() {
		return "RideProvider [P_Id=" + P_Id + ", P_Name=" + P_Name + ", P_Phone=" + P_Phone + ", P_Email=" + P_Email
				+ ", P_Drivers_License=" + P_Drivers_License + "]";
	}

}
