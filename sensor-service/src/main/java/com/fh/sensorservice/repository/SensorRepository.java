package com.fh.sensorservice.repository;

import com.fh.sensorservice.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The SensorRepository interface is a Spring Data JPA repository responsible for
 * managing and performing database operations on Sensor entities in the Sensor
 * Service application.
 *
 * It extends JpaRepository, providing generic CRUD (Create, Read, Update, Delete) operations
 * on the Sensor entity with the primary key of type Long.
 */

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
