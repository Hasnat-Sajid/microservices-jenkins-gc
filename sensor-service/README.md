# Sensor Service

The Sensor Service in the Microservices HA project manages sensors by providing endpoints for creating, retrieving, updating, and deleting sensor information. It communicates with the Config Server for configuration details and is registered with Eureka for service discovery.

## Project Structure

The main application class for the Sensor Service is `SensorServiceApplication`, located in the `com.fh.sensorservice` package. This class is annotated with `@SpringBootApplication` to enable Spring Boot features and `@EnableDiscoveryClient` for Eureka integration.

## Controller and DTOs

### Sensor Controller
The SensorController class defines REST endpoints for managing sensors. It handles CRUD operations for sensors and interacts with the SensorService to process requests.

### DTOs (Data Transfer Objects)
SensorRequest and SensorResponse are DTOs used for transferring data between the client and the service.

### Sensor Type Enum
SensorType is an enum representing the types of sensors (OUTDOOR, INDOOR, WATER).

### Sensor Model
The Sensor class is a JPA Entity representing a sensor. It includes fields such as name, location, isActive, and sensorType.

## Repository and Service

### Sensor Repository
The SensorRepository is a Spring Data JPA repository for managing Sensor entities.

### Sensor Service
The SensorService class contains business logic for creating, retrieving, updating, and deleting sensors.

## Configuration

### Eureka Configuration
The application is configured as a Eureka client, specifying its name and instance ID.

### Config Server Integration
The application integrates with the Config Server to retrieve configuration properties.


## How to Run
Ensure that the Microservices HA project is cloned, and Docker is installed and running. Follow the steps in the Starting the Application Guide with IntelliJ to initiate the entire application, including the Sensor Service.

## Additional Information
For more details on Spring Boot, Eureka, and Spring Cloud Config, refer to the official documentation.

