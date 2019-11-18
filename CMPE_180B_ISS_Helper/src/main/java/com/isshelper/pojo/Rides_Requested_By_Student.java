package com.isshelper.pojo;

import org.springframework.stereotype.Component;

@Component
public class Rides_Requested_By_Student {
	private int RRBS_Id;
	private String RRBS_Date;
	private String RRBS_Time;
	private String RBBS_Air_Code;
	private int RRBS_T_Number;
	private int RRBS_Seats;
	/**
	 * @return the rRBS_Id
	 */
	public int getRRBS_Id() {
		return RRBS_Id;
	}
	/**
	 * @param rRBS_Id the rRBS_Id to set
	 */
	public void setRRBS_Id(int rRBS_Id) {
		RRBS_Id = rRBS_Id;
	}
	/**
	 * @return the rRBS_Date
	 */
	public String getRRBS_Date() {
		return RRBS_Date;
	}
	/**
	 * @param rRBS_Date the rRBS_Date to set
	 */
	public void setRRBS_Date(String rRBS_Date) {
		RRBS_Date = rRBS_Date;
	}
	/**
	 * @return the rRBS_Time
	 */
	public String getRRBS_Time() {
		return RRBS_Time;
	}
	/**
	 * @param rRBS_Time the rRBS_Time to set
	 */
	public void setRRBS_Time(String rRBS_Time) {
		RRBS_Time = rRBS_Time;
	}
	/**
	 * @return the rBBS_Air_Code
	 */
	public String getRBBS_Air_Code() {
		return RBBS_Air_Code;
	}
	/**
	 * @param rBBS_Air_Code the rBBS_Air_Code to set
	 */
	public void setRBBS_Air_Code(String rBBS_Air_Code) {
		RBBS_Air_Code = rBBS_Air_Code;
	}
	/**
	 * @return the rRBS_T_Number
	 */
	public int getRRBS_T_Number() {
		return RRBS_T_Number;
	}
	/**
	 * @param rRBS_T_Number the rRBS_T_Number to set
	 */
	public void setRRBS_T_Number(int rRBS_T_Number) {
		RRBS_T_Number = rRBS_T_Number;
	}
	/**
	 * @return the rRBS_Seats
	 */
	public int getRRBS_Seats() {
		return RRBS_Seats;
	}
	/**
	 * @param rRBS_Seats the rRBS_Seats to set
	 */
	public void setRRBS_Seats(int rRBS_Seats) {
		RRBS_Seats = rRBS_Seats;
	}
	@Override
	public String toString() {
		return "RidesRequestedByStudent [RRBS_Id=" + RRBS_Id + ", RRBS_Date=" + RRBS_Date + ", RRBS_Time=" + RRBS_Time
				+ ", RBBS_Air_Code=" + RBBS_Air_Code + ", RRBS_T_Number=" + RRBS_T_Number + ", RRBS_Seats=" + RRBS_Seats
				+ "]";
	}
	
	
}
