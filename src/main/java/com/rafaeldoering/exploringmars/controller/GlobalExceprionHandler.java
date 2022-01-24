package com.rafaeldoering.exploringmars.controller;

import java.util.ArrayList;
import java.util.List;

import com.rafaeldoering.exploringmars.lib.ExceptionResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceprionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException exception) {
    List<String> errors = new ArrayList<>();
    exception.getBindingResult().getAllErrors().forEach((error) -> {
      String errorMessage = error.getDefaultMessage();
      errors.add(errorMessage);
    });
    
    ExceptionResponse response = new ExceptionResponse(
      HttpStatus.BAD_REQUEST.value(),
      errors
    );

    return new ResponseEntity<ExceptionResponse>(
      response,
      HttpStatus.valueOf(response.getStatusCode())
    );
  }

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<ExceptionResponse> databaseConnectionFailsException(Exception exception) {
    ExceptionResponse response = new ExceptionResponse(
      HttpStatus.INTERNAL_SERVER_ERROR.value(),
      exception.getMessage()
    );

    return new ResponseEntity<ExceptionResponse>(
      response,
      HttpStatus.valueOf(response.getStatusCode())
    );
  }
}
