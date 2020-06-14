/******************************************
 - File Name        : ExceptionController
 - Author           : Neha Vishwakarma
 - Creation Date    : 13-05-2020
 - Description      : This is an exception controller class to handle the exception.
 					    *****************************************/ 

package com.cg.appointmentservice.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(AppointmentNotFoundException.class)
	public String handleexception(AppointmentNotFoundException e) {
		return e.getMessage();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
	    Map<String, String> errors = new HashMap<>();
	     
	    ex.getConstraintViolations().forEach(cv -> {
	        errors.put("message", cv.getMessage());
	        errors.put("path", (cv.getPropertyPath()).toString());
	    }); 
	 
	    return errors;
	}
}

