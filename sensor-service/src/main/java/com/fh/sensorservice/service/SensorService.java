package com.fh.sensorservice.service;

import com.fh.sensorservice.dto.SensorRequest;
import com.fh.sensorservice.dto.SensorResponse;
import com.fh.sensorservice.model.Sensor;
import com.fh.sensorservice.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The SensorService class provides business logic for managing sensors
 * in the Sensor Service application. It handles operations such as creating,
 * retrieving, updating, and deleting sensors, including validation checks.
 *
 * This service interacts with the SensorRepository to perform database operations
 * and maps entities to DTOs for presentation.
 *
 * @Service annotation marks this class as a Spring service, making it eligible for
 * component scanning and dependency injection.
 * @RequiredArgsConstructor annotation from Lombok generates a constructor with parameters for
 * all final fields, injecting the necessary dependencies for the SensorService to function.
 * @Slf4j annotation from Lombok generates a logger field named "log" to facilitate logging.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SensorService {

    private final SensorRepository sensorRepository;


    /**
     * Creates a new sensor based on the provided SensorRequest.
     *
     * @param sensorRequest The request object containing information to create a new sensor.
     */
    public void createSensor(SensorRequest sensorRequest) {
        log.info("Creating a new sensor with name: {}", sensorRequest.getName());
        Sensor sensor = Sensor.builder().name(sensorRequest.getName()).location(sensorRequest.getLocation()).isActive(sensorRequest.getIsActive()).sensorType(sensorRequest.getSensorType()).build();

        sensorRepository.save(sensor);
        log.info("Sensor {} is saved.", sensor.getId());
    }



    /**
     * Retrieves all sensors and maps them to SensorResponse objects.
     *
     * @return List of SensorResponse objects containing information about all sensors.
     */
    public List<SensorResponse> getAllSensors() {
        log.info("Retrieving all sensors");
        List<Sensor> sensors = sensorRepository.findAll();
        return sensors.stream().map(this::mapToSensorResponse).toList();
    }


    /**
     * Maps a Sensor entity to a SensorResponse object.
     *
     * @param sensor The Sensor entity to map.
     * @return SensorResponse object containing information about the sensor.
     */
    private SensorResponse mapToSensorResponse(Sensor sensor) {
        return SensorResponse.builder().id(sensor.getId()).name(sensor.getName()).location(sensor.getLocation()).isActive(sensor.getIsActive()).sensorType(sensor.getSensorType()).build();
    }


    /**
     * Retrieves a sensor by its ID and maps it to a SensorResponse object.
     *
     * @param id The ID of the sensor to retrieve.
     * @return SensorResponse object containing information about the requested sensor.
     * @throws EntityNotFoundException if the sensor with the specified ID is not found.
     */
    public SensorResponse getSensorByID(Long id) {
        log.info("Retrieving sensor with ID: {}", id);
        return sensorRepository.findById(id).map(this::mapToSensorResponse).orElseThrow(() -> {
            log.error("Sensor not found with ID: {}", id);
            return new EntityNotFoundException("Sensor not found with ID: " + id);
        });
    }


    /**
     * Updates an existing sensor with the provided SensorRequest.
     *
     * @param id                The ID of the sensor to update.
     * @param sensorRequest The request object containing updated information for the sensor.
     * @throws EntityNotFoundException if the sensor with the specified ID is not found.
     */
    public void updateSensor(Long id, SensorRequest sensorRequest) {
        log.info("Updating sensor with ID: {}...", id);
        Sensor sensor = sensorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sensor not found."));
        Sensor updatedSensor = updateSensorFields(sensor, sensorRequest);
        sensorRepository.save(updatedSensor);
        log.info("Sensor with the ID: {} was succesfully updated.", id);
    }


    /**
     * Updates the fields of a Sensor entity with the values from the provided SensorRequest.
     *
     * @param sensor         The Sensor entity to update.
     * @param sensorRequest The request object containing updated information for the sensor.
     * @return Updated Sensor entity.
     */
    private Sensor updateSensorFields(Sensor sensor, SensorRequest sensorRequest) {

        sensor.setName(sensorRequest.getName());
        sensor.setLocation(sensorRequest.getLocation());
        sensor.setIsActive(sensorRequest.getIsActive());
        sensor.setSensorType(sensorRequest.getSensorType());

        return sensor;
    }


    /**
     * Deletes a sensor by its ID.
     *
     * @param id The ID of the sensor to delete.
     * @throws EntityNotFoundException if the sensor with the specified ID is not found.
     */
    public void deleteSensor(Long id) {
        log.info("Deleting sensor with ID: {}...", id);
        sensorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sensor not found."));
        sensorRepository.deleteById(id);
        log.info("Sensor with the ID: {} was succesfully deleted.", id);
    }
}
