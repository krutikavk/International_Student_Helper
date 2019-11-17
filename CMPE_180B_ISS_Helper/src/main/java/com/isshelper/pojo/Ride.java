package com.isshelper.pojo;
import java.util.Date;

public class Ride {
	
	//kk-R_Id will be set directly by database--may not be required
	//private int R_Id; 			 			//IDENTITY(1,1) PRIMARY KEY
	
	/* kk- USING @TEMPORAL Have to check/test how to use use this
	 * be aware that if you choose this solution, your date will appear as a  
	 * timestamp when fetched from db. It won't have the nice formatting 'yyyy-MM-dd
	 */
	
	//@Temporal(TemporalType.TIMESTAMP) 
	private Date R_Time;
	private float R_Rating;					//(R_Rating between 0 and 10),
	private String R_Starting_Air_Code;
	private String R_Starting_Terminal;
	//foreign key (R_Starting_Air_Code, R_Starting_Terminal) references Terminal (T_Air_code, T_Number)
	
	
	//Getters
	//R_Id will not need a setter as DB will directly set the value of R_Id
	
	public Date getR_Time() {
		return R_Time;
	}
	
	public float getR_Rating() {
		return R_Rating;
	}
	
	public String getR_Starting_Air_Code() {
		return R_Starting_Air_Code;
	}
	
	public String getR_Starting_Terminal() {
		return R_Starting_Terminal;
	}
	
	//Setters
	public void setR_Time(Date r_time) {
		R_Time = r_time;
	}
	
	public void setR_Rating(float r_rating) {
		R_Rating = r_rating;
	}
	
	public void setR_Starting_Air_Code(String r_starting_air_code) {
		R_Starting_Air_Code = r_starting_air_code;
	}
	
	public void setR_Starting_TerminalString (String r_starting_terminal) {
		R_Starting_Terminal = r_starting_terminal;
	}
	
	
	//toString
	public String toString() {
		return "Ride Time: " + R_Time + ", Rating: " + R_Rating + ", Starting airport: " + R_Starting_Air_Code + ", R_Starting_Terminal: " + R_Starting_Terminal;
	}
}
