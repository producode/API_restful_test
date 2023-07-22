package com.apitest.API_restful_test.controller;

import jakarta.validation.ConstraintViolationException;
import org.hsqldb.HsqlException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.ConstraintViolation;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(HsqlException.class)
    public ResponseEntity<?> handleValidationErrorsHsql(HsqlException ex) {
        return ResponseEntity.badRequest().body("{\"message\":\" El correo ya esta registrado\"}");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleValidationErrorsConstraint(ConstraintViolationException ex) {
        List<String> errorMessages = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList();

        return ResponseEntity.badRequest().body("{\"message\":\"" + errorMessages.get(0) + "\"}");
    }
}
