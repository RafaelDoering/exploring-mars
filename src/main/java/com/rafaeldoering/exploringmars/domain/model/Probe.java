package com.rafaeldoering.exploringmars.domain.model;

public interface Probe extends Entity {
  String getName();
  CardinalDirection getDirection();
  void turnLeft();
  void turnRight();
  void moveForward() throws Exception;
}
