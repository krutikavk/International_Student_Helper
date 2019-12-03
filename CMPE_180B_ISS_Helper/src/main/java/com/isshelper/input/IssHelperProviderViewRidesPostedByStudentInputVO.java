
//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.input;

public class IssHelperProviderViewRidesPostedByStudentInputVO {

	private int seats;
	private String drivers_Lisence;
	private String date;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "IssHelperProviderViewRidesPostedByStudentInputVO [seats=" + seats + ", drivers_Lisence="
				+ drivers_Lisence + ", date=" + date + "]";
	}



	

}
