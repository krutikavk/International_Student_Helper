
//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.output;

public class IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO {
	private int R_Id;
	private String R_Date;
	private String R_Time;
	private int R_Rating;
	private String R_Starting_Air_Code;
	private int R_Starting_Terminal;
	private int R_Current;
	private int R_Total;
	private String S_Name;
	private String S_Email;

	public int getR_Id() {
		return R_Id;
	}

	public void setR_Id(int r_Id) {
		R_Id = r_Id;
	}

	public String getR_Date() {
		return R_Date;
	}

	public void setR_Date(String r_Date) {
		R_Date = r_Date;
	}

	public String getR_Time() {
		return R_Time;
	}

	public void setR_Time(String r_Time) {
		R_Time = r_Time;
	}

	public int getR_Rating() {
		return R_Rating;
	}

	public void setR_Rating(int r_Rating) {
		R_Rating = r_Rating;
	}

	public String getR_Starting_Air_Code() {
		return R_Starting_Air_Code;
	}

	public void setR_Starting_Air_Code(String r_Starting_Air_Code) {
		R_Starting_Air_Code = r_Starting_Air_Code;
	}

	public int getR_Starting_Terminal() {
		return R_Starting_Terminal;
	}

	public void setR_Starting_Terminal(int i) {
		R_Starting_Terminal = i;
	}

	public int getR_Current() {
		return R_Current;
	}

	public void setR_Current(int r_Current) {
		R_Current = r_Current;
	}

	public int getR_Total() {
		return R_Total;
	}

	public void setR_Total(int r_Total) {
		R_Total = r_Total;
	}

	public String getS_Name() {
		return S_Name;
	}

	public void setS_Name(String s_Name) {
		S_Name = s_Name;
	}

	public String getS_Email() {
		return S_Email;
	}

	public void setS_Email(String s_Email) {
		S_Email = s_Email;
	}

	@Override
	public String toString() {
		return "IssHelperProviderDashBoardRidesPostedByProviderOutputVO [R_Id=" + R_Id + ", R_Date=" + R_Date
				+ ", R_Time=" + R_Time + ", R_Rating=" + R_Rating + ", R_Starting_Air_Code=" + R_Starting_Air_Code
				+ ", R_Starting_Terminal=" + R_Starting_Terminal + ", R_Current=" + R_Current + ", R_Total=" + R_Total
				+ ", S_Name=" + S_Name + ", S_Email=" + S_Email + "]";
	}

}
