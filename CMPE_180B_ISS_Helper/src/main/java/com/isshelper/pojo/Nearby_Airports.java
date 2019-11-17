package com.isshelper.pojo;

public class Nearby_Airports {
	private int N_U_Id; 			//foreign key references University(U_Id),
	private String N_A_Code; 		//varchar(4) foreign key references Airport(Air_Code),
	
	//primary key (N_U_Id, N_A_Code)
	
	//Getters
	public int getN_U_Id() {
		return N_U_Id;
	}
	
	public String getN_A_Code() {
		return N_A_Code;
	}
	
	//Setters
	public void setN_U_Id(int n_u_id) {
		N_U_Id = n_u_id;
	}
	
	public void setN_A_Code(String n_a_code) {
		N_A_Code = n_a_code;
	}
	
	//toString
	public String toString() {
		return "Nearby Airport ID: " + N_U_Id + ", Airport code: " + N_A_Code;
	}
}
