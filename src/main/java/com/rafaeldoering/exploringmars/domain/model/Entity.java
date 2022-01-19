package com.rafaeldoering.exploringmars.domain.model;

public interface Entity {
  Coordinate getCoordinates();
  Mesh getMesh();
  void deploy(Mesh mesh, Coordinate coordinate);
  void move(Coordinate coordinate);
}
