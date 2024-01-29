package com.fh.sensorservice.model;

import com.fh.sensorservice.enums.SensorType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Sensor class represents an entity for storing sensor information in the Sensor
 * Service application. It is mapped to the "sensors" table in the database using Java
 * Persistence API (JPA) annotations.
 *
 * The class is annotated with Lombok annotations to automatically generate common
 * boilerplate code such as getters, setters, constructors, and a builder pattern.
 *
 * @Entity annotation from JPA marks this class as a JPA entity, representing a table
 * in the database.
 * @Table annotation specifies the name of the table in the database ("sensors").
 * @Data annotation from Lombok generates getters, setters, toString, equals, and hashCode
 * methods, reducing the need for manual boilerplate code.
 * @Builder annotation from Lombok creates a builder pattern for easy and concise object creation.
 * @AllArgsConstructor annotation from Lombok generates a constructor with parameters for all fields.
 * @NoArgsConstructor annotation from Lombok generates a default, no-argument constructor.
 */
@Entity
@Table(name = "sensors")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Sensor {

    /**
     * The unique identifier of the sensor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long id;


    /**
     * The name of the sensor.
     */
    @Column(nullable = false)
    private String name;


    /**
     * The location where the sensor is placed or installed.
     */
    @Column(nullable = false)
    private String location;


    /**
     * The activity status of the sensor (active or inactive).
     */
    @Column(name= "is_active", nullable = false)
    private Boolean isActive;


    /**
     * The type of sensor as defined by the SensorType enum.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "sensor_type", nullable = false)
    private SensorType sensorType;

}
