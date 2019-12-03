package com.isshelper.pojo;
//SJSU CMPE 138 Fall2019 TEAM8
public class Amenities {
	private int A_U_Id;
	private String A_Name;
	private String A_Ammenities;
	//foreign key (A_U_Id, A_Name) references Apartment(A_U_Id, A_Name)
	
	//Getter functions
	public int getA_U_Id() {
		return A_U_Id;
	}
	
	public String getA_Name() {
		return A_Name;
	}
	
	public String getA_Ammenities() {
		return A_Ammenities;
	}

	
	//Setter functions
	public void setA_U_Id(int a_u_id) {
		A_U_Id = a_u_id;
	}
	
	public void setA_Name(String a_name) {
		A_Name  = a_name;
	}
	
	public void setA_Ammenities(String a_amenities) {
		A_Ammenities = a_amenities;
	} 
	
	//toString function
	public String toString() {
		return "Apartment ID: " + A_U_Id + ", Name: " + A_Name + ", Amenities: " + A_Ammenities;
	}
}
