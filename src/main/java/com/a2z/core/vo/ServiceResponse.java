package com.a2z.core.vo;

public class ServiceResponse {
	
	protected int statusCode;
	protected String message;

	public ServiceResponse(int code, String msg) {
		statusCode = code;
		message = msg;
	}

	public ServiceResponse() {

	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
