package com.rafaeldoering.exploringmars.domain.model;

import java.util.HashSet;
import java.util.Set;

public class CommonMesh implements Mesh {
  private String name;
  private Coordinate edgeCoordinate;
  private Set<Entity> entities;

  public CommonMesh(String name, Coordinate edgeCoordinate) {
    this.name = name;
    this.edgeCoordinate = edgeCoordinate;
    this.entities = new HashSet<Entity>();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Coordinate getEdgeCoordinate() {
    return this.edgeCoordinate;
  }

  @Override
  public boolean isCoordinateEmpty(Coordinate coordinate) {
    for (Entity entity : this.entities) {
      if (
        coordinate.getX() == entity.getCoordinates().getX() &&
        coordinate.getY() == entity.getCoordinates().getY()
      ) {
        return false;
      }
    }

    return true;
  }

  @Override
  public void addEntity(Entity entity) {
    this.entities.add(entity);
  }

  @Override
  public void removeEntity(Entity entity) {
    this.entities.remove(entity);
  }
}
