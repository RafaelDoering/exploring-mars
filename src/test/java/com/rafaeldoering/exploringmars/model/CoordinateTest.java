package com.rafaeldoering.exploringmars.model;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class CoordinateTest {
  @Test
  public void givenValidDataWhenInstantiateCoordinateThenReturnCoordinate() throws Exception {
    Coordinate coordinates = new Coordinate(10, 10);

    assertSame(10, coordinates.getX());
    assertSame(10, coordinates.getY());
  }

  @Test
  public void givenInvalidXWhenInstantiateCoordinateThenThrownError() throws Exception {    
    try {
      new Coordinate(-10, 10);
    } catch (Exception error){
      assertSame("X coordinate can only be a positive value", error.getMessage());
    }
  }

  @Test
  public void givenInvalidYWhenInstantiateCoordinateThenThrownError() throws Exception {    
    try {
      new Coordinate(10, -10);
    } catch (Exception error){
      assertSame("Y coordinate can only be a positive value", error.getMessage());
    }
  }
}
