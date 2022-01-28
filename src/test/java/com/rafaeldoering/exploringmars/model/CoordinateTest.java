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
}
