/******************************************
 - File Name        : AppointmentServiceInterface
 - Author           : Neha Vishwakarma
 - Creation Date    : 13-05-2020
 - Description      : This is an service interface that contains abstract methods for service logic.
 ******************************************/ 

package com.cg.appointmentservice.service;

import java.util.Date;
import java.util.List;

import com.cg.appointmentservice.exception.AppointmentNotFoundException;
import com.cg.appointmentservice.model.Appointment;

public interface AppointmentServiceInterface {

	public List<Appointment> getAppointment();
	public List<Appointment>getSpecificQuestions (String testname,Date appointmentdate) ;
	public String addAppointment(Appointment appointment);
	public String deleteAppointment(Integer appointmentid) throws AppointmentNotFoundException ;
	
}
