//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.input;

import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class IssHelperStudentSignUpInputVO {

	private String student_ID;
	private String name;
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$")
	private String email;
	@Pattern(regexp = "^(0|[1-9][0-9]*)$")
	private String phone;
	private String university;
	private String password;
	


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudent_ID() {
		return student_ID;
	}

	public void setStudent_ID(String student_ID) {
		this.student_ID = student_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "IssHelperStudentSignUpInputVO [student_ID=" + student_ID + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", university=" + university + "]";
	}

	

}
