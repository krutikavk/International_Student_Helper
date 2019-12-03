
//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.output;

public class IssHelperGetBrandNewRidesPostedByProviderOutputVO {
private String RPBP_Drivers_License;
	private int RPBP_Id;
	private String RPBP_Date;
	private String RPBP_Time;
	private String RPBP_From;
	private int RPBP_Total;

	
	
	public String getRPBP_Drivers_License() {
		return RPBP_Drivers_License;
	}

	public void setRPBP_Drivers_License(String rPBP_Drivers_License) {
		RPBP_Drivers_License = rPBP_Drivers_License;
	}

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

	public int getRPBP_Total() {
		return RPBP_Total;
	}

	public void setRPBP_Total(int rPBP_Total) {
		RPBP_Total = rPBP_Total;
	}

	@Override
	public String toString() {
		return "IssHelperGetBrandNewRidesPostedByProviderOutputVO [RPBP_Drivers_License=" + RPBP_Drivers_License
				+ ", RPBP_Id=" + RPBP_Id + ", RPBP_Date=" + RPBP_Date + ", RPBP_Time=" + RPBP_Time + ", RPBP_From="
				+ RPBP_From + ", RPBP_Total=" + RPBP_Total + "]";
	}

}
