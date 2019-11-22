package com.isshelper.input;

public class IssHelperGetBrandNewRidesPostedByProviderInputVO {

	private String date;
	private String landing_time;
	private String landing_airport;
	private int seats;
	private String street;
	private String city;
	private String state;
	private int zip;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLanding_time() {
		return landing_time;
	}
	public void setLanding_time(String landing_time) {
		this.landing_time = landing_time;
	}
	public String getLanding_airport() {
		return landing_airport;
	}
	public void setLanding_airport(String landing_airport) {
		this.landing_airport = landing_airport;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
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
	@Override
	public String toString() {
		return "IssHelperGetBrandNewRidesPostedByProvider [date=" + date + ", landing_time=" + landing_time
				+ ", landing_airport=" + landing_airport + ", seats=" + seats + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + "]";
	}
	
	

}
