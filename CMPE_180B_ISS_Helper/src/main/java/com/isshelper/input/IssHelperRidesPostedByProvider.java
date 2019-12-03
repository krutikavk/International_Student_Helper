
//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.input;

public class IssHelperRidesPostedByProvider {
	private
	String driversLicense;
	String date;
	String time;
	String from;
	int current;
	int total;
	/**
	 * @return the driversLicense
	 */
	public String getDriversLicense() {
		return driversLicense;
	}
	/**
	 * @param driversLicense the driversLicense to set
	 */
	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
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
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the current
	 */
	public int getCurrent() {
		return current;
	}
	/**
	 * @param current the current to set
	 */
	public void setCurrent(int current) {
		this.current = current;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "IssHelperRidesPostedByProvider [driversLicense=" + driversLicense + ", date=" + date + ", time=" + time
				+ ", from=" + from + ", current=" + current + ", total=" + total + "]";
	}
	
	
}
