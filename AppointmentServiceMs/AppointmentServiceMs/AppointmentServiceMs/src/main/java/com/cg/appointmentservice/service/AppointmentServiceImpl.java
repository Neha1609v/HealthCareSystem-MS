/******************************************
 - File Name        : AppointmentServiceImpl
 - Author           : Neha Vishwakarma
 - Creation Date    : 13-05-2020
 - Description      : This is service class which contains the business logic of Appointment Service
 ******************************************/ 

package com.cg.appointmentservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.appointmentservice.dao.AppointmentRepository;
import com.cg.appointmentservice.dto.AppointmentEntity;
import com.cg.appointmentservice.exception.AppointmentNotFoundException;
import com.cg.appointmentservice.model.Appointment;


@Service
public class AppointmentServiceImpl implements AppointmentServiceInterface{
	@Autowired
	AppointmentRepository repository;
	
	/******************************************
	 - Method Name      : getAppointment
	 - Input Parameters : No input parameters required
	 - Return type      : List<Appointment>
	 - Author           : Neha Vishwakarma
	 - Creation Date    : 13-06-2020
	 - Description      : Fetching all appointment present in database.
	  ******************************************/ 

	@Override
	public List<Appointment> getAppointment() {
		List< AppointmentEntity> entityList=repository.findAll();
		List<Appointment> appointList = new ArrayList<>();
		for (AppointmentEntity entity : entityList) {
			Appointment appoint=new Appointment();
			appoint.setAppointmentid(entity.getAppointmentId());
			appoint.setCustomername(entity.getCustomername());
			appoint.setCentername(entity.getCentername());
			appoint.setTestname(entity.getTestname());
			appoint.setAppointmentdate(entity.getAppointmentdate());
			appoint.setCenterId(entity.getCenterId());
			appointList.add(appoint);

		}
		return appointList;
	}

	/******************************************
	 - Method Name      : getSpecificQuestions
	 - Input Parameters : testname,appointmentdate
	 - Return type      : List<Appointment>
	 - Author           : Neha Vishwakarma
	 - Creation Date    : 13-06-2020
	 - Description      : Fetching appointment that matches with input parameters present in database.
	  ******************************************/ 
	@Override
	public List<Appointment> getSpecificQuestions(String testname, Date appointmentdate) {
		List<AppointmentEntity> entitylist=repository.getSpecificQuestions(testname,appointmentdate);
		List<Appointment> appointlist=new ArrayList<>();
			for(AppointmentEntity entity:entitylist)
				{
				Appointment appoint=new Appointment();
				appoint.setAppointmentid(entity.getAppointmentId());;
				appoint.setCustomername(entity.getCustomername());
				appoint.setCentername(entity.getCentername());
				appoint.setTestname(entity.getTestname());
				appoint.setAppointmentdate(entity.getAppointmentdate());
				appoint.setCenterId(entity.getCenterId());
				appointlist.add(appoint);
				}
	return appointlist;
	}
	/******************************************
	 - Method Name      : addAppointment
	 - Input Parameters : Appointment Object
	 - Return type      : String
	 - Author           : Neha Vishwakarma
	 - Creation Date    : 13-06-2020
	 - Description      :Inserting new appointment in database.
	  ******************************************/ 
	@Override
	public String addAppointment(Appointment appointment) {
		AppointmentEntity entity=new AppointmentEntity();
		entity.setCentername(appointment.getCentername());
		entity.setCenterId(appointment.getCenterId());
		entity.setCustomername(appointment.getCustomername());
		entity.setTestname(appointment.getTestname());
		entity.setAppointmentdate(appointment.getAppointmentdate());
		repository.saveAndFlush(entity);
		String msg= "Appointment added successfully";
		return msg;
	}
	/******************************************
	 - Method Name      : deleteAppointment
	 - Input Parameters : appointmentid
	 - Return type      : String
	 - Author           : Neha Vishwakarma
	 - Creation Date    : 13-06-2020
	 - Description      :Inserting new appointment in database.
	  ******************************************/ 
	@Override
	public String deleteAppointment(Integer appointmentid) throws AppointmentNotFoundException {
		Optional<AppointmentEntity> optional= repository.findById(appointmentid);
		 if(optional.isPresent()) {
			repository.deleteById(appointmentid);
			return "appointment record deleted successfully!";
		 }
		 else
			 throw new AppointmentNotFoundException("appointment not found for the given Id"); 
	}
	}

