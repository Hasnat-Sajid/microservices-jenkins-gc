package com.fh.measurementservice.repository;

/**
 * The MeasurementRepository interface is a Spring Data JPA repository responsible for
 * managing and performing database operations on Measurement entities in the Measurement
 * Service application.
 *
 * It extends JpaRepository, providing generic CRUD (Create, Read, Update, Delete) operations
 * on the Measurement entity with the primary key of type Long.
 */
import com.fh.measurementservice.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
