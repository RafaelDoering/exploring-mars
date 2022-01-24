package com.rafaeldoering.exploringmars.lib;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
  private int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
  private List<String> errors;

  public ExceptionResponse(int statusCode, String errorMessage) {
    List<String> errors = new ArrayList<String>();
    errors.add(errorMessage);

    this.statusCode = statusCode;
    this.errors = errors;
  }
}
