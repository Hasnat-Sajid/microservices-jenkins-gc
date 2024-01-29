package com.fh.measurementservice.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The SensorServiceClient interface defines the contract for communication with the
 * "sensor-service" via Feign, a declarative web service client.
 * It includes a method for checking the existence of a sensor by its ID
 */
@FeignClient(name = "sensor-service")
public interface SensorServiceClient {


    /**
     * Checks the existence of a sensor by its ID.
     *
     * @param sensorId The unique identifier of the sensor to check.
     * @return ResponseEntity<?> containing the response from the "sensor-service".
     *         The response may include information about the sensor or an error message.
     */
    @GetMapping("/api/sensor/{id}")
    ResponseEntity<?> checkSensorExists(@PathVariable("id") Long sensorId);
}

