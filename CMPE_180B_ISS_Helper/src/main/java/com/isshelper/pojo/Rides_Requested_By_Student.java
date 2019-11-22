package com.isshelper.pojo;

import org.springframework.stereotype.Component;

@Component
public class Rides_Requested_By_Student {
	private int RRBS_Id;
	private String RRBS_S_Id;
	private String RRBS_Date;
	private String RRBS_Time;
	private String RBBS_Air_Code;
	private int RRBS_T_Number;
	private int RRBS_Seats;
	private String RRBS_Street;
	private String RRBS_City;
	private String RRBS_State;
	private int RRBS_Zip;

	
	
	/**
	 * @return the rRBS_S_Id
	 */
	public String getRRBS_S_Id() {
		return RRBS_S_Id;
	}

	/**
	 * @param rRBS_S_Id the rRBS_S_Id to set
	 */
	public void setRRBS_S_Id(String rRBS_S_Id) {
		RRBS_S_Id = rRBS_S_Id;
	}

	/**
	 * @return the rRBS_Street
	 */
	public String getRRBS_Street() {
		return RRBS_Street;
	}

	/**
	 * @param rRBS_Street the rRBS_Street to set
	 */
	public void setRRBS_Street(String rRBS_Street) {
		RRBS_Street = rRBS_Street;
	}

	/**
	 * @return the rRBS_City
	 */
	public String getRRBS_City() {
		return RRBS_City;
	}

	/**
	 * @param rRBS_City the rRBS_City to set
	 */
	public void setRRBS_City(String rRBS_City) {
		RRBS_City = rRBS_City;
	}

	/**
	 * @return the rRBS_State
	 */
	public String getRRBS_State() {
		return RRBS_State;
	}

	/**
	 * @param rRBS_State the rRBS_State to set
	 */
	public void setRRBS_State(String rRBS_State) {
		RRBS_State = rRBS_State;
	}

	/**
	 * @return the rRBS_Zip
	 */

	/**
	 * @return the rRBS_Id
	 */
	public int getRRBS_Id() {
		return RRBS_Id;
	}

	/**
	 * @return the rRBS_Zip
	 */
	public int getRRBS_Zip() {
		return RRBS_Zip;
	}

	/**
	 * @param rRBS_Zip the rRBS_Zip to set
	 */
	public void setRRBS_Zip(int rRBS_Zip) {
		RRBS_Zip = rRBS_Zip;
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
