
//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.output;

public class IssHelperAppartmentsOutputVO {

	private String A_Name;
	private float A_Distance;
	private String A_Website;
	private String A_Street;
	private String A_City;
	private String A_State;
	private int A_Zip;

	public String getA_Name() {
		return A_Name;
	}

	public void setA_Name(String a_Name) {
		A_Name = a_Name;
	}

	public float getA_Distance() {
		return A_Distance;
	}

	public void setA_Distance(float a_Distance) {
		A_Distance = a_Distance;
	}

	public String getA_Website() {
		return A_Website;
	}

	public void setA_Website(String a_Website) {
		A_Website = a_Website;
	}

	public String getA_Street() {
		return A_Street;
	}

	public void setA_Street(String a_Street) {
		A_Street = a_Street;
	}

	public String getA_City() {
		return A_City;
	}

	public void setA_City(String a_City) {
		A_City = a_City;
	}

	public String getA_State() {
		return A_State;
	}

	public void setA_State(String a_State) {
		A_State = a_State;
	}

	

	public int getA_Zip() {
		return A_Zip;
	}

	public void setA_Zip(int a_Zip) {
		A_Zip = a_Zip;
	}

	@Override
	public String toString() {
		return "IssHelperAppartmentsOutputVO [A_Name=" + A_Name + ", A_Distance=" + A_Distance + ", A_Website="
				+ A_Website + ", A_Street=" + A_Street + ", A_City=" + A_City + ", A_State=" + A_State + ", A_Zip="
				+ A_Zip + "]";
	}

}
