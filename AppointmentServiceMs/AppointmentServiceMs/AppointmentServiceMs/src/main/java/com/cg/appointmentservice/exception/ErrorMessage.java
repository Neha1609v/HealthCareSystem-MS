 /******************************************
 - File Name        : ErrorMessage
 - Author           : Neha Vishwakarma
 - Creation Date    : 13-05-2020
 - Description      : This is an Error message class to display the error message.
 					    *****************************************/ 

package com.cg.appointmentservice.exception;

public class ErrorMessage {
	private int statusCode;
	private String errorMessage;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
