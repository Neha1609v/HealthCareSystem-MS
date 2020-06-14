/******************************************
 - File Name        : AppointmentServiceApplication
 - Author           : Neha Vishwakarma
 - Creation Date    : 13-05-2020
 - Description      : This is main class from where the application starts executing.
 ******************************************/ 

package com.cg.appointmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppointmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentServiceApplication.class, args);
	}

}
