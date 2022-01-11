package com.cg.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class OnlinetripmanagementApplication {

	public static void main(String[] args) {
	    log.info("Application Started.....");
		SpringApplication.run(OnlinetripmanagementApplication.class, args);
	    log.info("Application Configured.....");
	}
	
}
