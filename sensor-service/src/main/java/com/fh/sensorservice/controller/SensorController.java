package com.fh.sensorservice.controller;

/**
 * The SensorController class provides RESTful endpoints for managing sensors
 * in the Sensor Service application. It handles HTTP requests related to
 * creating, retrieving, updating, and deleting sensors.
 *
 * This controller is mapped to the "/api/sensor" path, and it supports
 * operations such as creating, retrieving all, retrieving by ID, updating, and deleting
 * sensors.
 *
 * @RestController annotation indicates that this class is a controller that handles
 * HTTP requests and returns the response in a RESTful manner.
 * @RequestMapping("/api/sensor") annotation specifies the base URL path for all
 * endpoints in this controller.
 * @RequiredArgsConstructor annotation generates a constructor with a parameter for each
 * field that requires initialization, injecting the dependencies needed for the
 * SensorController to function.
 */

import com.fh.sensorservice.dto.SensorRequest;
import com.fh.sensorservice.dto.SensorResponse;
import com.fh.sensorservice.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensor")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    /**
     * Handles HTTP POST requests to create a new sensor.
     *
     * @param sensorRequest The request body containing information to create a new sensor.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSensor(@RequestBody SensorRequest sensorRequest) {
        sensorService.createSensor(sensorRequest);
    }

    /**
     * Handles HTTP GET requests to retrieve all sensors.
     *
     * @return List of SensorResponse objects containing information about all sensors.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SensorResponse> getAllSensors() {
        return sensorService.getAllSensors();
    }


    /**
     * Handles HTTP GET requests to retrieve a sensor by its ID.
     *
     * @param id The ID of the sensor to retrieve.
     * @return SensorResponse object containing information about the requested sensor.
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SensorResponse getSensorByID(@PathVariable Long id) {
        return sensorService.getSensorByID(id);
    }


    /**
     * Handles HTTP PUT requests to update an existing sensor.
     *
     * @param id                The ID of the sensor to update.
     * @param sensorRequest The request body containing updated information for the sensor.
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateSensor(@PathVariable Long id, @RequestBody SensorRequest sensorRequest) {
        sensorService.updateSensor(id, sensorRequest);
    }

    /**
     * Handles HTTP DELETE requests to delete a sensor by its ID.
     *
     * @param id The ID of the sensor to delete.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensor(id);
    }
}
