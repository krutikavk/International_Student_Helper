package com.isshelper.pojo;
//SJSU CMPE 138 Fall2019 TEAM8
public class University {
	private int U_Id;
	private String U_Name;
	private String U_State;
	private String U_City;
	private String U_Street;
	private int U_Zip;
	
	
	//Setter functions
	public void setU_Id (int u_Id) {
		U_Id = u_Id;
	}
	
	public void setU_Name (String u_Name) {
		U_Name = u_Name;
	}
	
	public void setU_State (String u_State) {
		U_State = u_State;
	}
		
	public void setU_City (String u_City) {
		U_City = u_City;
	}
	
	public void setU_Street (String u_Street) {
		U_Street = u_Street;
	}
	
	public void setU_Zip (int u_Zip) {
		U_Zip = u_Zip;
	}
	
	
	//Getter functions
	public int getU_Id () {
		return U_Id;
	}
	
	public String getU_Name () {
		return U_Name;
	}
	
	public String getU_State () {
		return U_State;
	}
		
	public String getU_City () {
		return U_City;
	}
	
	public String getU_Street () {
		return U_Street;
	}
	
	public int getU_Zip () {
		return U_Zip;
	}
	
	public String toString() 
    { 
        return "University ID: " + U_Id + ", University Name: " + U_Name + ", Address: " + U_State + " " + U_City + " " + U_Street + " " + U_Zip; 
    } 
}
