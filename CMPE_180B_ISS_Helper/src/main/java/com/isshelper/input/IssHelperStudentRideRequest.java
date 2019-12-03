
//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.input;

public class IssHelperStudentRideRequest {
	
	private int id;
	private String student_ID;
	private String date;
	private String time;
	private String aircode;
	private int terminalNo;
	private int seats;
	private String Street;
	private String City;
	private String State;
	private int Zip;
	
	
	/**
	 * @return the street
	 */
	public String getStreet() {
		return Street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		Street = street;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		City = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		State = state;
	}
	/**
	 * @return the zip
	 */
	public int getZip() {
		return Zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		Zip = zip;
	}
	/**
	 * @return the date
	 * 
	 * 
	 * 
	 */
	
	
	
	public int getId() {
		return id;
	}
	/**
	 * @return the student_ID
	 */
	public String getStudent_ID() {
		return student_ID;
	}
	/**
	 * @param student_ID the student_ID to set
	 */
	public void setStudent_ID(String student_ID) {
		this.student_ID = student_ID;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	/**
	 * @return the id
	 */
	
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the aircode
	 */
	public String getAircode() {
		return aircode;
	}
	/**
	 * @param aircode the aircode to set
	 */
	public void setAircode(String aircode) {
		this.aircode = aircode;
	}
	/**
	 * @return the terminalNo
	 */
	public int getTerminalNo() {
		return terminalNo;
	}
	/**
	 * @param terminalNo the terminalNo to set
	 */
	public void setTerminalNo(int terminalNo) {
		this.terminalNo = terminalNo;
	}
	/**
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "IssHelperStudentRideRequest [date=" + date + ", time=" + time + ", aircode=" + aircode + ", terminalNo="
				+ terminalNo + ", seats=" + seats + "]";
	}
	
	

}
