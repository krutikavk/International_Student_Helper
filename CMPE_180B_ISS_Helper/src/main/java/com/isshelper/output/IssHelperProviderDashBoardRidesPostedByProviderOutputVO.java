
//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.output;

public class IssHelperProviderDashBoardRidesPostedByProviderOutputVO {

	private int RPBP_Id;
	private String RPBP_Date;
	private String RPBP_Time;
	private String RPBP_From;
	private int RPBP_Current;
	private int RPBP_Total;

	public int getRPBP_Id() {
		return RPBP_Id;
	}

	public void setRPBP_Id(int rPBP_Id) {
		RPBP_Id = rPBP_Id;
	}

	public String getRPBP_Date() {
		return RPBP_Date;
	}

	public void setRPBP_Date(String rPBP_Date) {
		RPBP_Date = rPBP_Date;
	}

	public String getRPBP_Time() {
		return RPBP_Time;
	}

	public void setRPBP_Time(String rPBP_Time) {
		RPBP_Time = rPBP_Time;
	}

	public String getRPBP_From() {
		return RPBP_From;
	}

	public void setRPBP_From(String rPBP_From) {
		RPBP_From = rPBP_From;
	}

	public int getRPBP_Current() {
		return RPBP_Current;
	}

	public void setRPBP_Current(int rPBP_Current) {
		RPBP_Current = rPBP_Current;
	}

	public int getRPBP_Total() {
		return RPBP_Total;
	}

	public void setRPBP_Total(int rPBP_Total) {
		RPBP_Total = rPBP_Total;
	}

	@Override
	public String toString() {
		return "IssHelperProviderDashBoardRidesPostedByProviderOutputVO [RPBP_Id=" + RPBP_Id + ", RPBP_Date="
				+ RPBP_Date + ", RPBP_Time=" + RPBP_Time + ", RPBP_From=" + RPBP_From + ", RPBP_Current=" + RPBP_Current
				+ ", RPBP_Total=" + RPBP_Total + "]";
	}

}
