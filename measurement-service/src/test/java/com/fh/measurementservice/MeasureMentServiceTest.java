package com.fh.measurementservice;

import com.fh.measurementservice.dto.MeasurementRequest;
import com.fh.measurementservice.dto.MeasurementResponse;
import com.fh.measurementservice.model.Measurement;
import com.fh.measurementservice.repository.MeasurementRepository;
import com.fh.measurementservice.interfaces.SensorServiceClient;
import com.fh.measurementservice.service.MeasurementService;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import jakarta.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MeasurementServiceTest {

	@Mock
	private MeasurementRepository measurementRepository;

	@Mock
	private SensorServiceClient sensorServiceClient;

	@InjectMocks
	private MeasurementService measurementService;

	private MeasurementRequest measurementRequest;
	private Measurement measurement;

	@BeforeEach
	void setUp() {
		LocalDateTime now = LocalDateTime.now();
		measurementRequest = new MeasurementRequest(1L, now, 25.0, 50.0);
		measurement = new Measurement(1L, 1L, now, 25.0, 50.0);
	}

	@Test
	void whenCreateMeasurementWithExistingSensor_thenMeasurementIsSaved() {
		when(sensorServiceClient.checkSensorExists(anyLong())).thenReturn(ResponseEntity.ok().build());
		when(measurementRepository.save(any(Measurement.class))).thenReturn(measurement);
		measurementService.createMeasurement(measurementRequest);
		verify(measurementRepository).save(any(Measurement.class));
	}

	@Test
	void whenCreateMeasurementWithNonExistingSensor_thenThrowEntityNotFoundException() {
		when(sensorServiceClient.checkSensorExists(anyLong())).thenThrow(FeignException.NotFound.class);
		assertThrows(EntityNotFoundException.class, () -> measurementService.createMeasurement(measurementRequest));
	}

	@Test
	void whenGetAllMeasurements_thenAllMeasurementsAreReturned() {
		List<Measurement> measurements = Arrays.asList(measurement, new Measurement(2L, 2L, LocalDateTime.now(), 20.0, 40.0));
		when(measurementRepository.findAll()).thenReturn(measurements);
		List<MeasurementResponse> result = measurementService.getAllMeasurements();
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	void whenGetMeasurementByIdAndMeasurementExists_thenMeasurementIsReturned() {
		when(measurementRepository.findById(1L)).thenReturn(Optional.of(measurement));
		MeasurementResponse result = measurementService.getMeasurementByID(1L);
		assertNotNull(result);
		assertEquals(1L, result.getId());
	}

	@Test
	void whenGetMeasurementByIdAndMeasurementDoesNotExist_thenThrowEntityNotFoundException() {
		when(measurementRepository.findById(1L)).thenReturn(Optional.empty());
		assertThrows(EntityNotFoundException.class, () -> measurementService.getMeasurementByID(1L));
	}

	@Test
	void whenUpdateMeasurementAndMeasurementExists_thenMeasurementIsUpdated() {
		when(measurementRepository.findById(1L)).thenReturn(Optional.of(measurement));
		when(sensorServiceClient.checkSensorExists(anyLong())).thenReturn(ResponseEntity.ok().build());
		when(measurementRepository.save(any(Measurement.class))).thenReturn(measurement);
		// ...
		measurementService.updateMeasurement(1L, measurementRequest);
		verify(measurementRepository).save(any(Measurement.class));
	}

	@Test
	void whenDeleteMeasurementAndMeasurementExists_thenMeasurementIsDeleted() {
		when(measurementRepository.findById(1L)).thenReturn(Optional.of(measurement));
		measurementService.deleteMeasurement(1L);
		verify(measurementRepository).deleteById(1L);
	}

	@Test
	void whenDeleteMeasurementAndMeasurementDoesNotExist_thenThrowEntityNotFoundException() {
		when(measurementRepository.findById(1L)).thenReturn(Optional.empty());
		assertThrows(EntityNotFoundException.class, () -> measurementService.deleteMeasurement(1L));
	}
}
