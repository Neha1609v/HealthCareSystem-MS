 /******************************************
 - File Name        :   AppointmentNotFoundException
 - Author           : Neha Vishwakarma
 - Creation Date    : 13-05-2020
 - Description      : This is an exception class which throws the exception when Appointment ID not found.
 					    *****************************************/ 

package com.cg.appointmentservice.exception;

public class AppointmentNotFoundException extends Exception{
	public AppointmentNotFoundException(String msg) {
		super(msg);
	}
}
