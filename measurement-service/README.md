# Measurement Service

The Measurement Service in the Microservices HA project is responsible for handling and managing sensor measurements. It provides endpoints for creating, retrieving, updating, and deleting measurements. Additionally, it communicates with the `sensor-service` through Feign client to ensure that measurements are associated with existing sensors.

## Project Structure

The main application class for the Measurement Service is `MeasurementServiceApplication`, located in the `com.fh.measurementservice` package. This class is annotated with `@SpringBootApplication` to enable Spring Boot features, `@EnableDiscoveryClient` to integrate with service discovery through Eureka, and `@EnableFeignClients` to enable Feign client functionality.

## Controller and DTOs

### Measurement Controller
The MeasurementController class defines REST endpoints for managing measurements. It handles CRUD operations for measurements and interacts with the MeasurementService to process requests.

### Global Exception Handler
The GlobalExceptionHandler class is a controller advice that handles EntityNotFoundException globally and returns a proper HTTP response with the error message.

### DTOs (Data Transfer Objects)
MeasurementRequest and MeasurementResponse are DTOs used for transferring data between the client and the service.

## Interfaces and Model

### Sensor Service Client
SensorServiceClient is a Feign client interface used for communication with the sensor-service to check the existence of a sensor.

### Measurement Model
The Measurement class is a JPA Entity representing a measurement. It includes fields such as sensorId, timestamp, temperature, and humidity.

## Service and Repository

### Measurement Service
The MeasurementService class contains business logic for creating, retrieving, updating, and deleting measurements. It also communicates with the sensor-service to ensure sensor existence.

### Measurement Repository
The MeasurementRepository is a Spring Data JPA repository for managing Measurement entities.

## Configuration

### Eureka Configuration
The application is configured as a Eureka client, specifying its name and instance ID.

### Config Server Integration
The application integrates with the Config Server to retrieve configuration properties.

## How to Run
Ensure that the Microservices HA project is cloned, and Docker is installed and running. Follow the steps in the Starting the Application Guide with IntelliJ to initiate the entire application, including the Measurement Service.

## Additional Information
For more details on Spring Boot, Eureka, Feign, and Spring Cloud Config, refer to the official documentation.


