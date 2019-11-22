package com.isshelper.output;

public class IssHelperRidesBookedByStudent {
	private int ride_Id;
	private String airport;
	private String terminal_Number;
	private String date;
	private String time;
	private String accepted_By;
	private String contact_Email;

	public int getRide_Id() {
		return ride_Id;
	}
	public void setRide_Id(int ride_Id) {
		this.ride_Id = ride_Id;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public String getTerminal_Number() {
		return terminal_Number;
	}
	public void setTerminal_Number(String terminal_Number) {
		this.terminal_Number = terminal_Number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAccepted_By() {
		return accepted_By;
	}
	public void setAccepted_By(String accepted_By) {
		this.accepted_By = accepted_By;
	}
	public String getContact_Email() {
		return contact_Email;
	}
	public void setContact_Email(String contact_Email) {
		this.contact_Email = contact_Email;
	}
	@Override
	public String toString() {
		return "IssHelperRidesBookedByStudent [ride_Id=" + ride_Id + ", airport=" + airport + ", terminal_Number="
				+ terminal_Number + ", date=" + date + ", time=" + time + ", accepted_By=" + accepted_By
				+ ", contact_Email=" + contact_Email + "]";
	}
	
	
}
