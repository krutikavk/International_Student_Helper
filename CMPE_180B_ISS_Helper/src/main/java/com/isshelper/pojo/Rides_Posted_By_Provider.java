package com.isshelper.pojo;

import org.springframework.stereotype.Component;

@Component
public class Rides_Posted_By_Provider {
	private 
	String RPBP_Drivers_License;
	String RPBP_Date;
	String RPBP_Time;
	String RPBP_From;
	int RPBP_Current;
	int RPBP_Total;
	/**
	 * @return the rPBP_Drivers_License
	 */
	public String getRPBP_Drivers_License() {
		return RPBP_Drivers_License;
	}
	/**
	 * @param rPBP_Drivers_License the rPBP_Drivers_License to set
	 */
	public void setRPBP_Drivers_License(String rPBP_Drivers_License) {
		RPBP_Drivers_License = rPBP_Drivers_License;
	}
	/**
	 * @return the rPBP_Date
	 */
	public String getRPBP_Date() {
		return RPBP_Date;
	}
	/**
	 * @param rPBP_Date the rPBP_Date to set
	 */
	public void setRPBP_Date(String rPBP_Date) {
		RPBP_Date = rPBP_Date;
	}
	/**
	 * @return the rPBP_Time
	 */
	public String getRPBP_Time() {
		return RPBP_Time;
	}
	/**
	 * @param rPBP_Time the rPBP_Time to set
	 */
	public void setRPBP_Time(String rPBP_Time) {
		RPBP_Time = rPBP_Time;
	}
	/**
	 * @return the rPBP_From
	 */
	public String getRPBP_From() {
		return RPBP_From;
	}
	/**
	 * @param rPBP_From the rPBP_From to set
	 */
	public void setRPBP_From(String rPBP_From) {
		RPBP_From = rPBP_From;
	}
	/**
	 * @return the rPBP_Current
	 */
	public int getRPBP_Current() {
		return RPBP_Current;
	}
	/**
	 * @param rPBP_Current the rPBP_Current to set
	 */
	public void setRPBP_Current(int rPBP_Current) {
		RPBP_Current = rPBP_Current;
	}
	/**
	 * @return the rPBP_Total
	 */
	public int getRPBP_Total() {
		return RPBP_Total;
	}
	/**
	 * @param rPBP_Total the rPBP_Total to set
	 */
	public void setRPBP_Total(int rPBP_Total) {
		RPBP_Total = rPBP_Total;
	}
	@Override
	public String toString() {
		return "Rides_Posted_By_Provider [RPBP_Drivers_License=" + RPBP_Drivers_License + ", RPBP_Date=" + RPBP_Date
				+ ", RPBP_Time=" + RPBP_Time + ", RPBP_From=" + RPBP_From + ", RPBP_Current=" + RPBP_Current
				+ ", RPBP_Total=" + RPBP_Total + "]";
	}
	
	
	
}

//RPBP_Id	RPBP_Drivers_License	RPBP_Date	RPBP_Time	RPBP_From	RPBP_Current	RPBP_Total
