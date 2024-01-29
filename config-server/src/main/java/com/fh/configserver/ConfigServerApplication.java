package com.fh.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * ConfigServerApplication is the main class that initializes and runs the Config Server for centralized configuration management.
 * It uses Spring Boot and the Spring Cloud Config Server annotation (@EnableConfigServer) to enable the Config Server functionality.
 *
 *
 * The Config Server is responsible for serving centralized configuration to other microservices in the system.
 * Microservices can retrieve their configuration from this server, allowing for easy management and updating of
 * configurations without requiring a redeployment of individual services.
 *
 *
 * To start the Config Server, run the {@link SpringApplication#run(Class, String...)} method with the {@link ConfigServerApplication} class.
 * This will start the Spring Boot application and initialize the Config Server
 *
 * The main method is the entry point for starting the Config Server as a standalone Spring Boot application.
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	/**
	 * The main method to start the Config Server application.
	 *
	 *
	 * This method initializes the Spring Boot application and enables the Config Server using the {@link EnableConfigServer} annotation.
	 *
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
