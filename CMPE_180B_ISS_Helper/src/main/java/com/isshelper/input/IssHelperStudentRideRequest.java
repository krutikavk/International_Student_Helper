package com.isshelper.input;

public class IssHelperStudentRideRequest {
	
	private int id;
	private String date;
	private String time;
	private String aircode;
	private int terminalNo;
	private int seats;
	/**
	 * @return the date
	 */
	public int getId() {
		return id;
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
