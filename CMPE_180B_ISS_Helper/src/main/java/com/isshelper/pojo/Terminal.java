package com.isshelper.pojo;
//SJSU CMPE 138 Fall2019 TEAM8
public class Terminal {

	private String T_Air_code;
	private String T_Number;
	public String getT_Air_code() {
		return T_Air_code;
	}
	public void setT_Air_code(String t_Air_code) {
		T_Air_code = t_Air_code;
	}
	public String getT_Number() {
		return T_Number;
	}
	public void setT_Number(String t_Number) {
		T_Number = t_Number;
	}
	@Override
	public String toString() {
		return "Terminal [T_Air_code=" + T_Air_code + ", T_Number=" + T_Number + "]";
	}
	
	

}
