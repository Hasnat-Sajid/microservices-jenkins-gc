# Config Server

The Config Server in the Microservices HA project is a central component responsible for managing and serving configuration properties to other microservices. It utilizes Spring Cloud Config Server to provide a centralized configuration management solution.

## Project Structure

The main application class for the Config Server is `ConfigServerApplication`, located in the `com.fh.configserver` package. This class is annotated with `@SpringBootApplication` to enable Spring Boot features and `@EnableConfigServer` to enable the configuration server functionality.


## Configuration
- The Config Server is configured with the following properties:
spring.application.name=config-server
server.port=8888
spring.cloud.config.server.git.uri=https://github.com/Hasnat-Sajid/microservices-config-server
spring.cloud.config.server.git.clone-on-start=true

spring.application.name: Application name for the Config Server.
server.port: Port on which the Config Server runs.
spring.cloud.config.server.git.uri: URI of the Git repository containing configuration files.
spring.cloud.config.server.git.clone-on-start: Configures the server to clone the Git repository on startup.

## How to Run
Ensure that the Microservices HA project is cloned, and Docker is installed and running. Follow the steps in the Starting the Application Guide with IntelliJ to initiate the entire application, including the Config Server.

## Additional Information
For more details on Spring Cloud Config Server and centralized configuration management, refer to the official documentation.


