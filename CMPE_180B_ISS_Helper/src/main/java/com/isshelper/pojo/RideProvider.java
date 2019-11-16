package com.isshelper.pojo;

public class RideProvider {

	private int P_Id;
	private String P_Name;
	private int P_Phone;
	private String P_Email;
	private String P_Drivers_License;
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
	public int getP_Phone() {
		return P_Phone;
	}
	public void setP_Phone(int p_Phone) {
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
	@Override
	public String toString() {
		return "RideProvider [P_Id=" + P_Id + ", P_Name=" + P_Name + ", P_Phone=" + P_Phone + ", P_Email=" + P_Email
				+ ", P_Drivers_License=" + P_Drivers_License + "]";
	}
	
	
}
