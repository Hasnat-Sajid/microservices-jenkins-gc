package com.fh.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * DiscoveryServerApplication is the main class that initializes and runs the Eureka Discovery Server.
 * It uses Spring Boot and the Spring Cloud Eureka Server annotation (@EnableEurekaServer) to enable the Eureka Server functionality.
 *
 *
 * The Eureka Discovery Server is responsible for registering and managing microservices within a distributed system.
 * Microservices can register themselves with the Eureka Server, and other services can discover and communicate with them.
 *
 *
 *
 * To start the Discovery Server, run the {@link SpringApplication#run(Class, String...)} method with the {@link DiscoveryServerApplication} class.
 * This will start the Spring Boot application and initialize the Eureka Discovery Server.
 *
 *
 *
 * The main method is the entry point for starting the Discovery Server as a standalone Spring Boot application.
 */

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	/**
	 * The main method to start the Discovery Server application.
	 * This method initializes the Spring Boot application and enables the Eureka Server using the {@link EnableEurekaServer} annotation.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}

}
