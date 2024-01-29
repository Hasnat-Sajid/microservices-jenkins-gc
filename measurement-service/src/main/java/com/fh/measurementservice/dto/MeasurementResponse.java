package com.fh.measurementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The MeasurementResponse class represents a data transfer object (DTO) for presenting
 * measurement information in the Measurement Service application. It encapsulates the
 * attributes necessary for displaying a measurement, including the unique identifier,
 * sensor ID, timestamp, temperature, and humidity.
 *
 * The class is annotated with Lombok annotations to automatically generate common
 * boilerplate code such as getters, setters, constructors, and a builder pattern.
 *
 * @Data annotation from Lombok generates getters, setters, toString, equals, and hashCode
 * methods, reducing the need for manual boilerplate code.
 * @Builder annotation from Lombok creates a builder pattern for easy and concise object creation.
 * @AllArgsConstructor annotation from Lombok generates a constructor with parameters for all fields.
 * @NoArgsConstructor annotation from Lombok generates a default, no-argument constructor.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementResponse {

    /**
     * The unique identifier of the measurement.
     */
    private Long id;

    /**
     * The unique identifier of the sensor associated with the measurement.
     */
    private Long sensorId;

    /**
     * The timestamp indicating when the measurement was recorded.
     */
    private LocalDateTime timestamp;

    /**
     * The temperature value recorded in the measurement.
     */
    private Double temperature;

    /**
     * The humidity value recorded in the measurement.
     */
    private Double humidity;
}
