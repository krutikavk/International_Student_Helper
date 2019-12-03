
//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.input;

public class IssHelperBookRideForStudentInputVO {

	private String student_Id;
	private int terminal;
	private int seats;
	private String drivers_Lisence;
	private String street;
	private String city;
	private String state;
	private int zip;
	private int rpbp_Id;
	private String rpbp_Date;
	private String rpbp_Time;
	private String rpbp_From;
	private int rpbp_Total;
	public String getStudent_Id() {
		return student_Id;
	}
	public void setStudent_Id(String student_Id) {
		this.student_Id = student_Id;
	}
	public int getTerminal() {
		return terminal;
	}
	public void setTerminal(int terminal) {
		this.terminal = terminal;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getRpbp_Id() {
		return rpbp_Id;
	}
	public void setRpbp_Id(int rpbp_Id) {
		this.rpbp_Id = rpbp_Id;
	}
	public String getRpbp_Date() {
		return rpbp_Date;
	}
	public void setRpbp_Date(String rpbp_Date) {
		this.rpbp_Date = rpbp_Date;
	}
	public String getRpbp_Time() {
		return rpbp_Time;
	}
	public void setRpbp_Time(String rpbp_Time) {
		this.rpbp_Time = rpbp_Time;
	}
	public String getRpbp_From() {
		return rpbp_From;
	}
	public void setRpbp_From(String rpbp_From) {
		this.rpbp_From = rpbp_From;
	}
	public int getRpbp_Total() {
		return rpbp_Total;
	}
	public void setRpbp_Total(int rpbp_Total) {
		this.rpbp_Total = rpbp_Total;
	}
	@Override
	public String toString() {
		return "IssHelperBookRideForStudentInputVO [student_Id=" + student_Id + ", terminal=" + terminal + ", seats="
				+ seats + ", drivers_Lisence=" + drivers_Lisence + ", street=" + street + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", rpbp_Id=" + rpbp_Id + ", rpbp_Date=" + rpbp_Date + ", rpbp_Time="
				+ rpbp_Time + ", rpbp_From=" + rpbp_From + ", rpbp_Total=" + rpbp_Total + "]";
	}
	
	
	

}
