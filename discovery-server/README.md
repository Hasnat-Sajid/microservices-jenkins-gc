# Discovery Server

The Discovery Server in the Microservices HA project is a Eureka server responsible for service registration and discovery. It enables microservices to locate and communicate with each other in a dynamic and scalable way.

## Project Structure

The main application class for the Discovery Server is `DiscoveryServerApplication`, located in the `com.fh.discoveryserver` package. This class is annotated with `@SpringBootApplication` to enable Spring Boot features and `@EnableEurekaServer` to enable the Eureka server functionality.


## Configuration

- The Discovery Server is configured with the following properties:
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false


server.port: Port on which the Discovery Server runs.
eureka.client.register-with-eureka: Specifies whether the server should register itself with Eureka. Set to false as this is the Eureka server itself.
eureka.client.fetch-registry: Specifies whether the server should fetch the registry information from Eureka. Set to false as this is the Eureka server itself.

## How to Run

Ensure that the Microservices HA project is cloned, and Docker is installed and running. Follow the steps in the Starting the Application Guide with IntelliJ to initiate the entire application, including the Discovery Server.


## Additional Information

For more details on Eureka Server and service discovery, refer to the official documentation

