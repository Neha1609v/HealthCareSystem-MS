/******************************************
 - File Name        : AppointmentRepository
 - Author           : Neha Vishwakarma
 - Creation Date    : 13-05-2020
 - Description      : This is repository class that consumes  which defines operations for 
 					  Entity class  in sAppointment Services 
 ******************************************/ 

package com.cg.appointmentservice.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.appointmentservice.dto.AppointmentEntity;


public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer>{
	 @Query("select t from  appointCheck t where t.testname=:testname and t.appointmentdate=:appointmentdate")
		
	 List<AppointmentEntity> getSpecificQuestions(@Param("testname")String testname,@PathVariable("appointmentdate")Date appointmentdate);

}
