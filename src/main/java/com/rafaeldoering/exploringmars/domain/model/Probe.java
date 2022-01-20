package com.rafaeldoering.exploringmars.domain.model;

public interface Probe extends Entity {
  String getName();
  CardinalDirection getDirection();
  void deploy(Mesh mesh, Coordinate coordinate, CardinalDirection orientation);
  void turnLeft();
  void turnRight();
  void moveForward() throws Exception;
}
