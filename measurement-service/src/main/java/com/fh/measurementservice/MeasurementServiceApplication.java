package com.fh.measurementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The MeasurementServiceApplication class serves as the entry point for the Measurement Service application.
 * It is annotated with Spring Boot's @SpringBootApplication, enabling auto-configuration and component scanning.
 * Additionally, it enables service discovery through @EnableDiscoveryClient and integrates with Feign clients
 * via @EnableFeignClients.
 *
 * @SpringBootApplication annotation indicates that this class is the main application class.
 * It enables Spring Boot's auto-configuration and component scanning.
 * @EnableDiscoveryClient annotation enables service registration and discovery with Spring Cloud's service discovery.
 * @EnableFeignClients annotation enables the use of Feign clients for declarative REST communication.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MeasurementServiceApplication {

	/**
	 * The main method that kicks off the execution of the Measurement Service application.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MeasurementServiceApplication.class, args);
	}

}
