package com.fh.measurementservice.controller;

import com.fh.measurementservice.dto.MeasurementRequest;
import com.fh.measurementservice.dto.MeasurementResponse;
import com.fh.measurementservice.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The MeasurementController class provides RESTful endpoints for managing measurements
 * in the Measurement Service application. It handles HTTP requests related to
 * creating, retrieving, updating, and deleting measurements.
 *
 * This controller is mapped to the "/api/measurement" path, and it supports
 * operations such as creating, retrieving all, retrieving by ID, updating, and deleting
 * measurements.
 *
 * @RestController annotation indicates that this class is a controller that handles
 * HTTP requests and returns the response in a RESTful manner.
 * @RequestMapping("/api/measurement") annotation specifies the base URL path for all
 * endpoints in this controller.
 * @RequiredArgsConstructor annotation generates a constructor with a parameter for each
 * field that requires initialization, injecting the dependencies needed for the
 * MeasurementController to function.
 */
@RestController
@RequestMapping("/api/measurement")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;

    /**
     * Handles HTTP POST requests to create a new measurement.
     *
     * @param measurementRequest The request body containing information to create a new measurement.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMeasurement(@RequestBody MeasurementRequest measurementRequest) {
        measurementService.createMeasurement(measurementRequest);
    }

    /**
     * Handles HTTP GET requests to retrieve all measurements.
     *
     * @return List of MeasurementResponse objects containing information about all measurements.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MeasurementResponse> getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }


    /**
     * Handles HTTP GET requests to retrieve a measurement by its ID.
     *
     * @param id The ID of the measurement to retrieve.
     * @return MeasurementResponse object containing information about the requested measurement.
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MeasurementResponse getMeasurementByID(@PathVariable Long id) {
        return measurementService.getMeasurementByID(id);
    }

    /**
     * Handles HTTP PUT requests to update an existing measurement.
     *
     * @param id                  The ID of the measurement to update.
     * @param measurementRequest The request body containing updated information for the measurement.
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMeasurement(@PathVariable Long id, @RequestBody MeasurementRequest measurementRequest) {
        measurementService.updateMeasurement(id, measurementRequest);
    }


    /**
     * Handles HTTP DELETE requests to delete a measurement by its ID.
     *
     * @param id The ID of the measurement to delete.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMeasurement(@PathVariable Long id) {
        measurementService.deleteMeasurement(id);
    }
}
