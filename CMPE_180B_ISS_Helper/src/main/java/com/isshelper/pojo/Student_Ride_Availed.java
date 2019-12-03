package com.isshelper.pojo;
//SJSU CMPE 138 Fall2019 TEAM8
public class Student_Ride_Availed {
	private int SRA_S_Id; 					//foreign key references Student(S_Id),
	private int SRA_Ride_Id; 				//foreign key references Ride(R_Id),
	private float SRA_Rating; 				//check (SRA_Rating between 0 and 10),
	//primary key (SRA_S_Id, SRA_Ride_Id
	
	//Getter functions
	public int getSRA_S_Id() {
		return SRA_S_Id;
	}
	
	public int getSRA_Ride_Id() {
		return SRA_Ride_Id;
	}
	
	public float getSRA_Rating() {
		return SRA_Rating;
	}
	
	//Setter functions
	public void getSRA_S_Id(int sra_s_id) {
		SRA_S_Id = sra_s_id;
	}
	
	public void getSRA_Ride_Id(int sra_ride_id) {
		SRA_Ride_Id = sra_ride_id;
	}
	
	public void getSRA_Rating(float sra_rating) {
		SRA_Rating = sra_rating;
	}
	
	//toString function
	public String toString() {
		return "Student ID: " + SRA_S_Id + " availed Ride ID: " + SRA_Ride_Id + ", Rating: " + SRA_Rating;
	}
}
