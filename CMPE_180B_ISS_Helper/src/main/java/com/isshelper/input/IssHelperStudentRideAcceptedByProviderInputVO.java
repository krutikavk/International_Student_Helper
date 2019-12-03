//SJSU CMPE 138 Fall2019 TEAM8

package com.isshelper.input;

public class IssHelperStudentRideAcceptedByProviderInputVO {
	
	private String rrbs_Air_Code;
	private String rrbs_S_Id;
	private int rrbs_Id;
	private int rrbs_T_Number;
	private int rrbs_Seats;
	private String rrbs_Time;
	private String rrbs_Date;
	private int seats;
	private String rrbs_Street;
	private String rrbs_City;
	private int rrbs_Zip;
	private String rrbs_State;
	
	public String getRrbs_Street() {
		return rrbs_Street;
	}
	public void setRrbs_Street(String rrbs_Street) {
		this.rrbs_Street = rrbs_Street;
	}
	public String getRrbs_City() {
		return rrbs_City;
	}
	public void setRrbs_City(String rrbs_City) {
		this.rrbs_City = rrbs_City;
	}
	
	public int getRrbs_Zip() {
		return rrbs_Zip;
	}
	public void setRrbs_Zip(int rrbs_Zip) {
		this.rrbs_Zip = rrbs_Zip;
	}
	public String getRrbs_State() {
		return rrbs_State;
	}
	public void setRrbs_State(String rrbs_State) {
		this.rrbs_State = rrbs_State;
	}

	private String drivers_Lisence;
	public String getRrbs_Air_Code() {
		return rrbs_Air_Code;
	}
	public void setRrbs_Air_Code(String rrbs_Air_Code) {
		this.rrbs_Air_Code = rrbs_Air_Code;
	}
	public String getRrbs_S_Id() {
		return rrbs_S_Id;
	}
	public void setRrbs_S_Id(String rrbs_S_Id) {
		this.rrbs_S_Id = rrbs_S_Id;
	}
	public int getRrbs_Id() {
		return rrbs_Id;
	}
	public void setRrbs_Id(int rrbs_Id) {
		this.rrbs_Id = rrbs_Id;
	}
	public int getRrbs_T_Number() {
		return rrbs_T_Number;
	}
	public void setRrbs_T_Number(int rrbs_T_Number) {
		this.rrbs_T_Number = rrbs_T_Number;
	}
	public int getRrbs_Seats() {
		return rrbs_Seats;
	}
	public void setRrbs_Seats(int rrbs_Seats) {
		this.rrbs_Seats = rrbs_Seats;
	}
	public String getRrbs_Time() {
		return rrbs_Time;
	}
	public void setRrbs_Time(String rrbs_Time) {
		this.rrbs_Time = rrbs_Time;
	}
	public String getRrbs_Date() {
		return rrbs_Date;
	}
	public void setRrbs_Date(String rrbs_Date) {
		this.rrbs_Date = rrbs_Date;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getDrivers_Lisence() {
		return drivers_Lisence;
	}
	public void setDrivers_Lisence(String drivers_Lisence) {
		this.drivers_Lisence = drivers_Lisence;
	}
	@Override
	public String toString() {
		return "IssHelperStudentRideAcceptedByProviderInputVO [rrbs_Air_Code=" + rrbs_Air_Code + ", rrbs_S_Id="
				+ rrbs_S_Id + ", rrbs_Id=" + rrbs_Id + ", rrbs_T_Number=" + rrbs_T_Number + ", rrbs_Seats=" + rrbs_Seats
				+ ", rrbs_Time=" + rrbs_Time + ", rrbs_Date=" + rrbs_Date + ", seats=" + seats + ", rrbs_Street="
				+ rrbs_Street + ", rrbs_City=" + rrbs_City + ", rrbs_Zip=" + rrbs_Zip + ", rrbs_State=" + rrbs_State
				+ ", drivers_Lisence=" + drivers_Lisence + "]";
	}
	
	

}
