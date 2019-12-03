
//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.output;

import org.springframework.stereotype.Component;

@Component
public class IssHelperStudentSignUpOutputVO {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
