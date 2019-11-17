package com.isshelper.pojo;
import java.util.Date;

public class Student_Arriving_Terminal {
	private int SAT_S_Id;				//foreign key references Student(S_Id),
	private String SAT_Air_Code; 		// varchar(4) not null,
	private String SAT_T_Number; 		//varchar(4) not null,
	private Date SAT_Date;
	//foreign key (SAT_Air_Code, SAT_T_Number) references Terminal(T_Air_Code, T_Number)
	
	//Getters
	public int getSAT_S_Id() {
		return SAT_S_Id;
	}
	
	public String getSAT_Air_Code() {
		return SAT_Air_Code;
	}
	
	public String SAT_T_Number() {
		return SAT_T_Number;
	}
	
	
	//Setters
	
	public void getSAT_S_Id(int sat_s_id) {
		SAT_S_Id = sat_s_id;
	}
	
	public void getSAT_Air_Code(String sat_air_code) {
		SAT_Air_Code = sat_air_code;
	}
	
	public void SAT_T_Number(String sat_t_number) {
		SAT_T_Number = sat_t_number;
	}
	
	
	//toString function
	public String toString() {
		return "Arriving Student ID: " + SAT_S_Id + ", Arriving airport code: " + SAT_Air_Code + ", Terminal: " + SAT_T_Number;
	}
}
