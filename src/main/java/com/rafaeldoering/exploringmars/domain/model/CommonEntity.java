package com.rafaeldoering.exploringmars.domain.model;

public class CommonEntity implements Entity {
  private Coordinate coordinate;
  private Mesh mesh;

  @Override
  public Coordinate getCoordinates() {
    return this.coordinate;
  }

  @Override
  public Mesh getMesh() {
    return this.mesh;
  }

  @Override
  public void deploy(Mesh mesh, Coordinate coordinate) {
    if (mesh.isCoordinateEmpty(coordinate)) {
      if (this.mesh != null) {
        this.mesh.removeEntity(this);
      }
      mesh.addEntity(this);
      this.mesh = mesh;
      this.coordinate = coordinate;
    } 
  }

  @Override
  public void move(Coordinate coordinate) {
    if (mesh.isCoordinateEmpty(coordinate)) {
      this.coordinate = coordinate;
    }
  }
}
