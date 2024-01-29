# Microservices HA

This project is developed as part of the course "Software Design and Frameworks for Networked Systems" by Franz Knipp. It implements a microservices architecture to provide a RESTful web service for storing and accessing sensor data.

## Repository Structure

This monorepo contains the following:

- (any other services)

Each service is contained within its own directory and includes its own README with service-specific documentation.

## Getting Started

# **Starting the Application Guide with IntelliJ**

This guideline expects you to already have cloned the REPO!
To initiate the application seamlessly using IntelliJ, follow the steps outlined below. Ensure that Docker is installed and running on your system.

1. **Start the Database:**
    - Utilize the provided Docker Compose file located in the root directory.
    - Execute the following command in the terminal within IntelliJ:
      ```bash
      docker-compose up -d
      ```

2. **Start Microservices in Sequence:**
   Start each microservice in the specified order to ensure a smooth and coherent initialization process. Navigate to the main file of each service within IntelliJ and execute the following steps:

    - **Discovery Server (discovery-server):**
        - Open the `discovery-server` project.
        - Locate the main file (e.g., `DiscoveryServerApplication.java`).
        - Run the application within IntelliJ.

    - **API Gateway (api-gateway):**
        - Open the `api-gateway` project.
        - Locate the main file (e.g., `ApiGatewayApplication.java`).
        - Run the application within IntelliJ.

    - **Config Server (config-server):**
        - Open the `config-server` project.
        - Locate the main file (e.g., `ConfigServerApplication.java`).
        - Run the application within IntelliJ.

    - **Sensor Service (sensor-service):**
        - Open the `sensor-service` project.
        - Locate the main file (e.g., `SensorServiceApplication.java`).
        - Run the application within IntelliJ.

    - **Measurement Service (measurement-service):**
        - Open the `measurement-service` project.
        - Locate the main file (e.g., `MeasurementServiceApplication.java`).
        - Run the application within IntelliJ.

3. **Multiple Instances of Sensor and Measurement Services:**
    - As the measurement and sensor services start on random ports, initiate two instances of each service within IntelliJ. You can achieve this by running the startup command for each service in separate configurations or terminals.

4. **Verify Application Status:**
    - Once all services are up and running, navigate to the "services" panel in IntelliJ to inspect the assigned ports for each service.

Your application is now up and running within IntelliJ, providing a convenient environment for managing and monitoring the microservices architecture.

You can find the api docu and the report in the test-data-and-resources folder.



## Usage

This microservices architecture provides a RESTful web service for storing and accessing sensor data. Below are general instructions on how to use the services, and you can find service-specific documentation in each service's respective README.

Feel free to explore the individual services for more detailed information on how to interact with them and incorporate them into your projects.

## Contributing

We welcome contributions to enhance and improve the project. To contribute, follow these guidelines:

1. Fork the repository and create your branch from `main`.
2. Make your changes and ensure that they adhere to the coding standards.
3. Test your changes thoroughly to avoid introducing bugs.
4. Submit a pull request, providing a clear description of the changes made and why they are beneficial.

### Coding Standards

- Adhere to the coding standards defined in each service's respective documentation.
- Ensure proper documentation for new features or changes.
- Write meaningful commit messages to maintain a clear history.

### Workflow Guidelines

- For major changes, open an issue to discuss the proposed modifications.
- Coordinate with other contributors through the project's communication channels.
- Be responsive to feedback and iterate on your contributions.

By contributing to this project, you agree to abide by the [MIT License](LICENSE) terms.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Professor Franz Knipp & Professor Daniel Mühlbachler-Pietrzykowski who provided guidance and support.

---
## DISCLAIMER: All text files were written by AI Agents after we provided them with drafts of our notes.