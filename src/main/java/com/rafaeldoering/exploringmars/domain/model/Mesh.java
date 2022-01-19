package com.rafaeldoering.exploringmars.domain.model;

public interface Mesh {
  String getName();
  Coordinate getEdgeCoordinate();
  void addEntity(Entity entity);
  void removeEntity(Entity entity);
  boolean isCoordinateEmpty(Coordinate coordinate);
}