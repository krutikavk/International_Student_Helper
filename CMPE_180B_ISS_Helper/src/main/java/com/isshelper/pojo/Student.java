package com.isshelper.pojo;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private int S_Id;
	private String S_Name;
	private String S_Email;
	private long S_Phone;
	private int S_University;

	public int getS_Id() {
		return S_Id;
	}

	public void setS_Id(int s_Id) {
		S_Id = s_Id;
	}

	public String getS_Name() {
		return S_Name;
	}

	public void setS_Name(String s_Name) {
		S_Name = s_Name;
	}

	public String getS_Email() {
		return S_Email;
	}

	public void setS_Email(String s_Email) {
		S_Email = s_Email;
	}

	public long getS_Phone() {
		return S_Phone;
	}

	public void setS_Phone(long s_Phone) {
		S_Phone = s_Phone;
	}

	public int getS_University() {
		return S_University;
	}

	public void setS_University(int s_University) {
		S_University = s_University;
	}
}
