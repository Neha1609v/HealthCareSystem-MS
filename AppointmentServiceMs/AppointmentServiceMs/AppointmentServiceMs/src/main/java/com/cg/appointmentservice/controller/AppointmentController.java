/******************************************
 - File Name        : AppointmentController
 - Author           : Neha Vishwakarma
 - Creation Date    : 13-05-2020
 - Description      : This is controller class that handles all http request 
 ******************************************/ 

package com.cg.appointmentservice.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.appointmentservice.dto.AppointmentEntity;
import com.cg.appointmentservice.exception.AppointmentNotFoundException;
import com.cg.appointmentservice.model.Appointment;
import com.cg.appointmentservice.service.AppointmentServiceImpl;
import com.cg.appointmentservice.service.AppointmentServiceInterface;

@RestController
@RequestMapping("/appoint")
public class AppointmentController {
	@Autowired
	AppointmentServiceImpl service;
	/****************************************************************************************************************************
	 - Method Name      : getAppointment
	 - Input Parameters : no input parameters
	 - Return type      : List<Appointment> 
	 - Author           : Neha Vishwakarma
	 - Creation Date    : 13-06-2020
	 - Description      : fetching the appointment information from the database.
	 - End point URL    : http://localhost:4448/appoint/getallAppointment
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/getallAppointment")
	public ResponseEntity<List<Appointment>> getAppointment() {
		List<Appointment> appointList=service.getAppointment();
		return new ResponseEntity<>(appointList,HttpStatus.OK);
		}
	
	/****************************************************************************************************************************
	 - Method Name      : getSpecificQuestions
	 - Input Parameters : testname,appointmentdate
	 - Return type      : List<Appointment> 
	 - Author           : Neha Vishwakarma
	 - Creation Date    : 13-06-2020
	 - Description      : Fetching appointment that matches with input parameters present in database.
	 - End point URL    : http://localhost:4448/appoint/{testname}/{appointmentdate}
	  ****************************************************************************************************************************/ 
		@GetMapping("/appointCheck/{testname}/{appointmentdate}")
		public ResponseEntity<List<Appointment>> getSpecificQuestions(@PathVariable("testname") String testname,@PathVariable("appointmentdate")Date appointmentdate ) {
		List<Appointment> appoint=service.getSpecificQuestions(testname,appointmentdate);
		return ResponseEntity.ok(appoint);
		}
		

		/****************************************************************************************************************************
		 - Method Name      : addAppointment
		 - Input Parameters : Appointment object
		 - Return type      : String
		 - Author           : Neha Vishwakarma
		 - Creation Date    : 13-06-2020
		 - Description      : inserting the appointment information into the database.
		 - End point URL    : http://localhost:4448/appoint/addAppointment
		  ****************************************************************************************************************************/ 
		@PostMapping("/addAppointment")
		public ResponseEntity<String> addAppointment(@Valid @RequestBody Appointment appointment)
		{
			String msg=service.addAppointment(appointment);
			ResponseEntity<String> response=new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
			return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
		}
		/****************************************************************************************************************************
		 - Method Name      : deleteAppointment
		 - Input Parameters : Appointment Object
		 - Return type      : String
		 - Author           : Neha Vishwakarma
		 - Creation Date    : 13-06-2020
		 - Description      : deleting the appointment information into the database.
		 - End point URL    : http://localhost:4448/appoint/deleteAppointment/{appointmentid}
		  ****************************************************************************************************************************/
		@DeleteMapping("/deleteAppointment/{appointmentid}")
		public ResponseEntity<String> deleteAppointment(@PathVariable Integer appointmentid) throws AppointmentNotFoundException{
		return ResponseEntity.ok( service.deleteAppointment(appointmentid));
		}

}
