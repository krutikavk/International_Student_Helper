package com.isshelper.pojo;

public class Ride_Address {
	//kk=does RA_Id hold address number? check
	private int RA_Id;					// IDENTITY(1,1) PRIMARY KEY,
	private int RA_R_Id;				// foreign key references Ride(R_Id),
	private String RA_Street;			// varchar(30) not null,
	private String RA_City; 			// varchar (20) not null,
	private String RA_State; 			// varchar (20) not null,
	private int RA_Zip; 				// not null check (len(cast(RA_Zip as varchar(20))) >= 3 and len(cast(RA_Zip as varchar(20))) <= 5),
	
	
	//Getters
	public int getRA_Id() {
		return RA_Id;
	}
	
	public int getRA_R_Id() {
		return RA_R_Id;
	}
	
	public String getRA_Street() {
		return RA_Street;
	}
	
	public String getRA_City() {
		return RA_City;
	}
	
	public String getRA_State() {
		return RA_State;
	}
	
	public int getRA_Zip() {
		return RA_Zip;
	}
	
	public String getAddress() {
		return RA_Street + " " + RA_City + " " + RA_State + " " + RA_Zip;
	}
	
	//Setters
	
	public void setRA_Id(int ra_id) {
		RA_Id = ra_id;
	}
	
	public void setRA_R_Id(int ra_r_id) {
		RA_R_Id = ra_r_id;
	}
	
	public void setRA_Street(String ra_street) {
		RA_Street = ra_street;
	}
	
	public void setRA_City(String ra_city) {
		RA_City = ra_city;
	}
	
	public void setRA_State(String ra_state) {
		RA_State = ra_state;
	}
	
	public void setRA_Zip(int ra_zip) {
		RA_Zip = ra_zip;
	}
	
	//toString
	
	public String toString() {
		return "Ride ID: " + RA_R_Id + " Address number: " + RA_Id + ", Address: " + getAddress();
	}
}
