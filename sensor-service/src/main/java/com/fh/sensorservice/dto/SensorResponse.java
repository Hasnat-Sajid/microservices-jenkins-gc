package com.fh.sensorservice.dto;

import com.fh.sensorservice.enums.SensorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The SensorResponse class represents a data transfer object (DTO) for presenting
 * sensor information in the Sensor Service application. It encapsulates the attributes
 * necessary for displaying a sensor, including its unique identifier, name, location,
 * activity status, and sensor type.
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
public class SensorResponse {

    /**
     * The unique identifier of the sensor.
     */
    private Long id;

    /**
     * The name of the sensor.
     */
    private String name;

    /**
     * The location where the sensor is placed or installed.
     */
    private String location;

    /**
     * The activity status of the sensor (active or inactive).
     */
    private Boolean isActive;

    /**
     * The type of sensor as defined by the SensorType enum.
     */
    private SensorType sensorType;
}
