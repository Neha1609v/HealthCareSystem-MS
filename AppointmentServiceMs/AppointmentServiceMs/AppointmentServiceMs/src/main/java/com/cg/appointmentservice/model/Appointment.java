/******************************************
 - File Name        :Appointment
 - Author           : Neha Vishwakarma
 - Creation Date    : 13-05-2020
 - Description      : This is an Appointment class that transfers data across the layers.
 					    *****************************************/ 

package com.cg.appointmentservice.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Appointment {

	private Integer appointmentid;
	
	private String customername;
	
	private String centername;
	

	private Integer centerId;
	
	private String testname;
	
	
	Date appointmentdate;

	public Integer getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCentername() {
		return centername;
	}

	public void setCentername(String centername) {
		this.centername = centername;
	}

	public String getTestname() {
		return testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public Date getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(Date appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}
}
