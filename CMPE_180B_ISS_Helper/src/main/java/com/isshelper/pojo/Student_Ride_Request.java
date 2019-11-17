package com.isshelper.pojo;

public class Student_Ride_Request {
	private int SRR_S_Id;				//foreign key references Student(S_Id),
	private int SRR_R_Id;				//foreign key references Ride(R_Id),
	//primary key (SRR_S_Id, SRR_R_Id)
	
	//Getters
	public int getSRR_S_Id() {
		return SRR_S_Id;
	}
	
	public int getSRR_R_Id() {
		return SRR_R_Id;
	}
	
	//Setters
	public void setSRR_S_Id(int srr_s_id) {
		SRR_S_Id = srr_s_id;
	}
	
	public void setSRR_R_Id(int srr_r_id) {
		SRR_R_Id = srr_r_id;
	}
	
	
	//toString
	
	public String toString() {
		return "Requesting student ID: " + SRR_S_Id + ", Ride ID: " + SRR_R_Id;
	}
}
