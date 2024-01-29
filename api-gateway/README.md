# API Gateway

The API Gateway is a central component in the Microservices HA project, responsible for routing and managing requests to the various microservices. It leverages Spring Cloud Gateway to provide a seamless and efficient communication layer between clients and the microservices.

## Project Structure

The main application class for the API Gateway is `ApiGatewayApplication`, located in the `com.fh.apigateway` package. This class is annotated with `@SpringBootApplication` to enable Spring Boot features, and `@EnableDiscoveryClient` to integrate with service discovery through Eureka.



## Configuration

The API Gateway is configured to interact with the Eureka discovery server and manage routes for the Sensor Service, Measurement Service, and Discovery Server.

### Eureka Configuration
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
spring.application.name=api-gateway


### Routes Configuration
- Routes for the Sensor Service:

- Identifier: sensor-service
Destination URI: lb://sensor-service
Predicate: Requests with the path /api/sensor/** are directed to the Sensor Service.
Routes for the Measurement Service:

- Identifier: measurement-service
Destination URI: lb://measurement-service
Predicate: Requests with the path /api/measurement/** are directed to the Measurement Service.
Routes for the Discovery Server:

- Identifier: discovery-server
Destination URI: http://localhost:8761
Predicate: Requests with the path /eureka/web are directed to the Discovery Server.
Filter: The path is set to /.
Route for the resources of the Discovery Server (css):

- Identifier: discovery-server-static
Destination URI: http://localhost:8761
Predicate: Requests with the path /eureka/** are directed to the Discovery Server for static resources (e.g., CSS files).

- CORS Configuration:
Allowed Origins: Requests from http://localhost:4200 are permitted.
Allowed Methods: GET, POST, PUT, DELETE.
Allowed Headers: All headers are allowed.
Allow Credentials: Credentials (e.g., cookies) are allowed to be included in the requests.

The CORS configuration allows requests from http://localhost:4200 and specifies allowed methods, headers, and credentials.

## How to Run
Ensure that the Microservices HA project is cloned, and Docker is installed and running. Follow the steps in the Starting the Application Guide with IntelliJ to initiate the entire application, including the API Gateway.

## Additional Information
For more details on each microservice, consult their respective README files in the project's root directory.

Feel free to explore and adapt the API Gateway for your specific requirements within the Microservices HA architecture.

