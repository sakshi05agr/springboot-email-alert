package com.etl.emailalert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class EmailalertApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmailalertApplication.class, args);
		System.out.println("🚀 Application started successfully");
	}

}
