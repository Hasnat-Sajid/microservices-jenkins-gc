package com.fh.sensorservice;

import com.fh.sensorservice.dto.SensorRequest;
import com.fh.sensorservice.dto.SensorResponse;
import com.fh.sensorservice.enums.SensorType;
import com.fh.sensorservice.model.Sensor;
import com.fh.sensorservice.repository.SensorRepository;
import com.fh.sensorservice.service.SensorService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SensorServiceTest {

    @Mock
    private SensorRepository sensorRepository;

    @InjectMocks
    private SensorService sensorService;

    private SensorRequest sensorRequest;
    private Sensor sensor;

    @BeforeEach
    void setUp() {
        sensorRequest = new SensorRequest("Temperature Sensor", "Lab 1", true, SensorType.INDOOR);
        sensor = new Sensor(1L, "Temperature Sensor", "Lab 1", true, SensorType.INDOOR);
    }

    @Test
    void whenCreateSensor_thenSensorIsSaved() {
        when(sensorRepository.save(any(Sensor.class))).thenReturn(sensor);
        sensorService.createSensor(sensorRequest);
        verify(sensorRepository).save(any(Sensor.class));
    }

    @Test
    void whenGetAllSensors_thenAllSensorsAreReturned() {
        List<Sensor> sensors = Arrays.asList(sensor, new Sensor(2L, "Humidity Sensor", "Lab 2", true, SensorType.OUTDOOR));
        when(sensorRepository.findAll()).thenReturn(sensors);
        List<SensorResponse> result = sensorService.getAllSensors();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void whenGetSensorByIdAndSensorExists_thenSensorIsReturned() {
        when(sensorRepository.findById(1L)).thenReturn(Optional.of(sensor));
        SensorResponse result = sensorService.getSensorByID(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void whenGetSensorByIdAndSensorDoesNotExist_thenThrowEntityNotFoundException() {
        when(sensorRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> sensorService.getSensorByID(1L));
    }

    @Test
    void whenUpdateSensorAndSensorExists_thenSensorIsUpdated() {
        when(sensorRepository.findById(1L)).thenReturn(Optional.of(sensor));
        when(sensorRepository.save(any(Sensor.class))).thenReturn(sensor);
        sensorService.updateSensor(1L, sensorRequest);
        verify(sensorRepository).save(sensor);
    }

    @Test
    void whenUpdateSensorAndSensorDoesNotExist_thenThrowEntityNotFoundException() {
        when(sensorRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> sensorService.updateSensor(1L, sensorRequest));
    }

    @Test
    void whenDeleteSensorAndSensorExists_thenSensorIsDeleted() {
        when(sensorRepository.findById(1L)).thenReturn(Optional.of(sensor));
        sensorService.deleteSensor(1L);
        verify(sensorRepository).deleteById(1L);
    }

    @Test
    void whenDeleteSensorAndSensorDoesNotExist_thenThrowEntityNotFoundException() {
        when(sensorRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> sensorService.deleteSensor(1L));
    }
}

