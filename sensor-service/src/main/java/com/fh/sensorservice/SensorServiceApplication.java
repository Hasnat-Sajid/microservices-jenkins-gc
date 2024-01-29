package com.fh.sensorservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * The SensorServiceApplication class serves as the entry point for the Sensor Service application.
 * It is annotated with Spring Boot's @SpringBootApplication, enabling auto-configuration and component scanning.
 * Additionally, it enables service discovery through @EnableDiscoveryClient.
 *
 * @SpringBootApplication annotation indicates that this class is the main application class.
 * It enables Spring Boot's auto-configuration and component scanning.
 * @EnableDiscoveryClient annotation enables service registration and discovery with Spring Cloud's service discovery.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SensorServiceApplication {

	/**
	 * The main method that kicks off the execution of the Sensor Service application.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SensorServiceApplication.class, args);
	}
}