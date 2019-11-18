package com.isshelper.pojo;

import org.springframework.stereotype.Component;

@Component
public class Ride {

	private int R_Id;
	private String R_Time;
	private String R_Rating;
	private String R_Starting_Air_Code;
	private int R_Starting_Terminal;
	private String R_Accepted_By;
	private int R_Current;
	private int R_Total;

	/**
	 * @return the r_Id
	 */
	public int getR_Id() {
		return R_Id;
	}

	/**
	 * @param r_Id the r_Id to set
	 */
	public void setR_Id(int r_Id) {
		R_Id = r_Id;
	}

	/**
	 * @return the r_Time
	 */
	public String getR_Time() {
		return R_Time;
	}

	/**
	 * @param r_Time the r_Time to set
	 */
	public void setR_Time(String r_Time) {
		R_Time = r_Time;
	}

	/**
	 * @return the r_Rating
	 */
	public String getR_Rating() {
		return R_Rating;
	}

	/**
	 * @param r_Rating the r_Rating to set
	 */
	public void setR_Rating(String r_Rating) {
		R_Rating = r_Rating;
	}

	/**
	 * @return the r_Starting_Air_Code
	 */
	public String getR_Starting_Air_Code() {
		return R_Starting_Air_Code;
	}

	/**
	 * @param r_Starting_Air_Code the r_Starting_Air_Code to set
	 */
	public void setR_Starting_Air_Code(String r_Starting_Air_Code) {
		R_Starting_Air_Code = r_Starting_Air_Code;
	}

	/**
	 * @return the r_Starting_Terminal
	 */
	public int getR_Starting_Terminal() {
		return R_Starting_Terminal;
	}

	/**
	 * @param r_Starting_Terminal the r_Starting_Terminal to set
	 */
	public void setR_Starting_Terminal(int r_Starting_Terminal) {
		R_Starting_Terminal = r_Starting_Terminal;
	}

	/**
	 * @return the r_Accepted_By
	 */
	public String getR_Accepted_By() {
		return R_Accepted_By;
	}

	/**
	 * @param r_Accepted_By the r_Accepted_By to set
	 */
	public void setR_Accepted_By(String r_Accepted_By) {
		R_Accepted_By = r_Accepted_By;
	}

	/**
	 * @return the r_Current
	 */
	public int getR_Current() {
		return R_Current;
	}

	/**
	 * @param r_Current the r_Current to set
	 */
	public void setR_Current(int r_Current) {
		R_Current = r_Current;
	}

	/**
	 * @return the r_Total
	 */
	public int getR_Total() {
		return R_Total;
	}

	/**
	 * @param r_Total the r_Total to set
	 */
	public void setR_Total(int r_Total) {
		R_Total = r_Total;
	}

	@Override
	public String toString() {
		return "Ride [R_Id=" + R_Id + ", R_Time=" + R_Time + ", R_Rating=" + R_Rating + ", R_Starting_Air_Code="
				+ R_Starting_Air_Code + ", R_Starting_Terminal=" + R_Starting_Terminal + ", R_Accepted_By="
				+ R_Accepted_By + ", R_Current=" + R_Current + ", R_Total=" + R_Total + "]";
	}

}
