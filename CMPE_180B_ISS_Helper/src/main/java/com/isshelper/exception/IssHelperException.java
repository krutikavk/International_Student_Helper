package com.isshelper.exception;

public class IssHelperException extends Exception {

	private String message;

	public IssHelperException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
