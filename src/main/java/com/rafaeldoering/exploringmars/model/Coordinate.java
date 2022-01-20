package com.rafaeldoering.exploringmars.model;

import javax.validation.constraints.Min;

import lombok.Getter;

@Getter
public class Coordinate {
  @Min(value = 0, message = "'x' must be greater than 0")
  private int x;

  @Min(value = 0, message = "'y' must be greater than 0")
  private int y;

  public Coordinate(int x, int y) throws Exception {
    this.x = x;
    this.y = y;
  }
}
