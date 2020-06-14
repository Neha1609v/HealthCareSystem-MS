 /******************************************
 - File Name        :  AppointmentEntity
 - Author           : Neha Vishwakarma
 - Creation Date    : 13-05-2020
 - Description      : This is an entity class to represent table in Database  
   
 *****************************************/ 


package com.cg.appointmentservice.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Entity(name="appointCheck")
@Table(name="Appointmentable")
public class AppointmentEntity {
	@Id
	@Column(name="appoint_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_generator") 
	@SequenceGenerator(name="seq_generator",initialValue=4,allocationSize=1,sequenceName="id_seq")
	private Integer appointmentId;
	
	@Column(name="center_id")
	@NotNull(message="center id is mandatory")
	private Integer centerId;
	
	@Column(name="cust_name")
	@NotNull(message="customer name is mandatory")
	private String customername;
	
	@Column(name="center_name")
	@NotNull(message="center name is mandatory")
	private String centername;
	
	@Column(name="test_name")
	@NotNull(message="test name is mandatory")
	private String testname;
	
	@Column(name="appoint_date")
	@NotNull(message="date is mandatory")
	Date appointmentdate;
	
	public AppointmentEntity() {}

	public AppointmentEntity(
			 Integer appointmentId, Integer centerId,String customername, String centername, String testname, Date appointmentdate) {
		super();
		this.appointmentId = appointmentId;
		this.centerId = centerId;
		this.customername = customername;
		this.centername = centername;
		this.testname = testname;
		this.appointmentdate = appointmentdate;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
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

}
