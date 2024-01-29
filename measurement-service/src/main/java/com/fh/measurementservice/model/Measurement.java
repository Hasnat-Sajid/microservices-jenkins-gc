package com.fh.measurementservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The Measurement class represents an entity for storing measurement data in the
 * Measurement Service application. It is mapped to the "measurements" table in the
 * database using Java Persistence API (JPA) annotations.
 *
 * The class is annotated with Lombok annotations to automatically generate common
 * boilerplate code such as getters, setters, constructors, and a builder pattern.
 *
 * @Entity annotation from JPA marks this class as a JPA entity, representing a table
 * in the database.
 * @Table annotation specifies the name of the table in the database ("measurements").
 * @Data annotation from Lombok generates getters, setters, toString, equals, and hashCode
 * methods, reducing the need for manual boilerplate code.
 * @AllArgsConstructor annotation from Lombok generates a constructor with parameters for all fields.
 * @NoArgsConstructor annotation from Lombok generates a default, no-argument constructor.
 * @Builder annotation from Lombok creates a builder pattern for easy and concise object creation.
 */
@Entity
@Table(name = "measurements")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Measurement {

    /**
     * The unique identifier of the measurement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private Long id;

    /**
     * The unique identifier of the sensor associated with the measurement.
     */
    @Column(name= "sensor_id", nullable = false)
    private Long sensorId;

    /**
     * The timestamp indicating when the measurement was recorded.
     */
    @Column(nullable = false)
    private LocalDateTime timestamp;

    /**
     * The temperature value recorded in the measurement.
     */
    @Column(nullable = false)
    private Double temperature;

    /**
     * The humidity value recorded in the measurement.
     */
    @Column(nullable = false)
    private Double humidity;
}
