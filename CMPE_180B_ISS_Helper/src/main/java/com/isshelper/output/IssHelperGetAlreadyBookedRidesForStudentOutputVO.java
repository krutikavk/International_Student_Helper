//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.output;

public class IssHelperGetAlreadyBookedRidesForStudentOutputVO {

	private int r_Id;
	private String r_Date;
	private String r_Time;
	private int r_Rating;
	private String r_Starting_Air_Code;
	private int r_Starting_Terminal;
	private String r_Accepted_By;
	private int r_Current;
	private int r_Total;

	public int getR_Id() {
		return r_Id;
	}

	public void setR_Id(int r_Id) {
		this.r_Id = r_Id;
	}

	public String getR_Date() {
		return r_Date;
	}

	public void setR_Date(String r_Date) {
		this.r_Date = r_Date;
	}

	public String getR_Time() {
		return r_Time;
	}

	public void setR_Time(String r_Time) {
		this.r_Time = r_Time;
	}

	public int getR_Rating() {
		return r_Rating;
	}

	public void setR_Rating(int r_Rating) {
		this.r_Rating = r_Rating;
	}

	public String getR_Starting_Air_Code() {
		return r_Starting_Air_Code;
	}

	public void setR_Starting_Air_Code(String r_Starting_Air_Code) {
		this.r_Starting_Air_Code = r_Starting_Air_Code;
	}

	public int getR_Starting_Terminal() {
		return r_Starting_Terminal;
	}

	public void setR_Starting_Terminal(int r_Starting_Terminal) {
		this.r_Starting_Terminal = r_Starting_Terminal;
	}

	public String getR_Accepted_By() {
		return r_Accepted_By;
	}

	public void setR_Accepted_By(String r_Accepted_By) {
		this.r_Accepted_By = r_Accepted_By;
	}

	public int getR_Current() {
		return r_Current;
	}

	public void setR_Current(int r_Current) {
		this.r_Current = r_Current;
	}

	public int getR_Total() {
		return r_Total;
	}

	public void setR_Total(int r_Total) {
		this.r_Total = r_Total;
	}

	@Override
	public String toString() {
		return "IssHelperGetAlreadyBookedRidesForStudentOutputVO [r_Id=" + r_Id + ", r_Date=" + r_Date + ", r_Time="
				+ r_Time + ", r_Rating=" + r_Rating + ", r_Starting_Air_Code=" + r_Starting_Air_Code
				+ ", r_Starting_Terminal=" + r_Starting_Terminal + ", r_Accepted_By=" + r_Accepted_By + ", r_Current="
				+ r_Current + ", r_Total=" + r_Total + "]";
	}

}
