package com.fh.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The main entry point for the API Gateway application.
 * This class initializes the Spring Boot application and enables service discovery.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	/**
	 * The main method that kicks off the execution of the API Gateway application.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
