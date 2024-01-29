package com.fh.measurementservice.service;

import com.fh.measurementservice.dto.MeasurementRequest;
import com.fh.measurementservice.dto.MeasurementResponse;
import com.fh.measurementservice.interfaces.SensorServiceClient;
import com.fh.measurementservice.model.Measurement;
import com.fh.measurementservice.repository.MeasurementRepository;
import feign.FeignException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The MeasurementService class provides business logic for managing measurements
 * in the Measurement Service application. It handles operations such as creating,
 * retrieving, updating, and deleting measurements, including validation checks.
 *
 * This service integrates with the SensorService through Feign to validate the existence
 * of sensors before creating or updating measurements.
 *
 * @Service annotation marks this class as a Spring service, making it eligible for
 * component scanning and dependency injection.
 * @RequiredArgsConstructor annotation from Lombok generates a constructor with parameters for
 * all final fields, injecting the necessary dependencies for the MeasurementService to function.
 * @Slf4j annotation from Lombok generates a logger field named "log" to facilitate logging.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorServiceClient sensorServiceClient;

    /**
     * Creates a new measurement based on the provided MeasurementRequest.
     *
     * @param measurementRequest The request object containing information to create a new measurement.
     * @throws EntityNotFoundException if the associated sensor does not exist.
     */
    public void createMeasurement(MeasurementRequest measurementRequest) {
        log.info("Attempting to create a new measurement for sensor ID: {}", measurementRequest.getSensorID());


        if (sensorDoesNotExist(measurementRequest.getSensorID())) {
            throw new EntityNotFoundException("Sensor with ID " + measurementRequest.getSensorID() + " does not exist.");
        }


        Measurement measurement = Measurement.builder()
                .sensorId(measurementRequest.getSensorID())
                .timestamp(measurementRequest.getTimestamp())
                .temperature(measurementRequest.getTemperature())
                .humidity(measurementRequest.getHumidity())
                .build();


        measurementRepository.save(measurement);
        log.info("Measurement {} is saved.", measurement.getId());
    }

    /**
     * Checks if a sensor with the specified ID exists.
     *
     * @param sensorID The ID of the sensor to check.
     * @return true if the sensor does not exist, false otherwise.
     */

    private boolean sensorDoesNotExist(Long sensorID) {
        try {
            ResponseEntity<?> response = sensorServiceClient.checkSensorExists(sensorID);
            return !response.getStatusCode().is2xxSuccessful();
        } catch (FeignException.NotFound e) {
            log.error("Sensor not found with ID: {}", sensorID);
            return true;
        } catch (FeignException e) {
            log.error("Error when checking sensor existence: {}", e.getMessage());
            return true;
        }
    }


    /**
     * Retrieves all measurements and maps them to MeasurementResponse objects.
     *
     * @return List of MeasurementResponse objects containing information about all measurements.
     */
    public List<MeasurementResponse> getAllMeasurements() {
        log.info("Retrieving all measurements");
        List<Measurement> measurements = measurementRepository.findAll();
        return measurements.stream().map(this::mapToMeasurementResponse).toList();
    }


    /**
     * Maps a Measurement entity to a MeasurementResponse object.
     *
     * @param measurement The Measurement entity to map.
     * @return MeasurementResponse object containing information about the measurement.
     */
    private MeasurementResponse mapToMeasurementResponse(Measurement measurement) {
        return MeasurementResponse.builder()
                .id(measurement.getId())
                .sensorId(measurement.getSensorId())
                .timestamp(measurement.getTimestamp())
                .temperature(measurement.getTemperature())
                .humidity(measurement.getHumidity())
                .build();
    }


    /**
     * Retrieves a measurement by its ID and maps it to a MeasurementResponse object.
     *
     * @param id The ID of the measurement to retrieve.
     * @return MeasurementResponse object containing information about the requested measurement.
     * @throws EntityNotFoundException if the measurement with the specified ID is not found.
     */
    public MeasurementResponse getMeasurementByID(Long id) {
        log.info("Retrieving measurement with ID: {}", id);
        return measurementRepository.findById(id).map(this::mapToMeasurementResponse).orElseThrow(() -> {
            log.error("Measurement not found with ID: {}", id);
            return new EntityNotFoundException("Measurement not found with ID: " + id);
        });
    }


    /**
     * Updates an existing measurement with the provided MeasurementRequest.
     *
     * @param id                  The ID of the measurement to update.
     * @param measurementRequest The request object containing updated information for the measurement.
     * @throws EntityNotFoundException if the associated sensor does not exist or the measurement with
     *                                 the specified ID is not found.
     */
    public void updateMeasurement(Long id, MeasurementRequest measurementRequest) {
        if (sensorDoesNotExist(measurementRequest.getSensorID())) {
            throw new EntityNotFoundException("Sensor with ID " + measurementRequest.getSensorID() + " does not exist.");
        }

        Measurement measurement = measurementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Measurement not found for update with ID: " + id));

        Measurement updatedMeasurement = updateMeasurementFields(measurement, measurementRequest);

        measurementRepository.save(updatedMeasurement);

        log.info("Measurement with ID: {} updated successfully", id);
    }


    /**
     * Updates the fields of a Measurement entity with the values from the provided MeasurementRequest.
     *
     * @param measurement         The Measurement entity to update.
     * @param measurementRequest The request object containing updated information for the measurement.
     * @return Updated Measurement entity.
     */
    private Measurement updateMeasurementFields(Measurement measurement, MeasurementRequest measurementRequest) {
        measurement.setSensorId(measurementRequest.getSensorID());
        measurement.setTimestamp(measurementRequest.getTimestamp());
        measurement.setTemperature(measurementRequest.getTemperature());
        measurement.setHumidity(measurement.getHumidity());

        return measurement;
    }


    /**
     * Deletes a measurement by its ID.
     *
     * @param id The ID of the measurement to delete.
     * @throws EntityNotFoundException if the measurement with the specified ID is not found.
     */
    public void deleteMeasurement(Long id) {
        log.info("Deleting measurement with ID: {}", id);
        Measurement measurement = measurementRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Measurement not found for deletion with ID: {}", id);
                    return new EntityNotFoundException("Measurement not found.");
                });
        measurementRepository.deleteById(id);
        log.info("Measurement with ID: {} deleted successfully", id);
    }
}
