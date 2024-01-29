package com.fh.measurementservice.controller.advice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * GlobalExceptionHandler is a controller advice class that handles global exceptions
 * for the Measurement Service application. It provides exception handling for
 * specific exceptions like EntityNotFoundException.
 *
 * ControllerAdvice annotation ensures that this class is used to define
 * global exception handling for all controllers in the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles the EntityNotFoundException and returns a ResponseEntity with a
     * corresponding HTTP status code and error message.
     *
     * @param ex The EntityNotFoundException thrown during the application execution.
     * @return ResponseEntity<String> containing the error message and HTTP status code.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

