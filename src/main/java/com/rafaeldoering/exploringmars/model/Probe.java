package com.rafaeldoering.exploringmars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "probes")
public class Probe extends BaseEntity {
  @Column(name = "name")
  private String name;

  @Column(name = "position_x")
  private int positionX;

  @Column(name = "position_y")
  private int positionY;

  @Column(name = "direction")
  @Enumerated(EnumType.STRING)
  private CardinalDirection direction;

  @ManyToOne
  @JoinColumn(name = "mesh_id")
  @JsonIgnoreProperties(value = { "probes" })
  private Mesh mesh;

  public Probe(String name) {
    this.name = name;
  }

  public void deploy(Mesh mesh, Coordinate coordinate, CardinalDirection direction) {
    if (mesh.isCoordinateEmpty(coordinate)) {
      if (this.mesh != null) {
        this.mesh.removeEntity(this);
      }
      mesh.addEntity(this);
      this.mesh = mesh;
      this.positionX = coordinate.getX();
      this.positionY = coordinate.getY();
      this.direction = direction;
    } 
  }

  public void turnLeft() {
    Direction direction = new Direction(this.direction);
    direction.turnLeft();
    this.direction = direction.getDirection();
  }

  public void turnRight() {
    Direction direction = new Direction(this.direction);
    direction.turnRight();
    this.direction = direction.getDirection();
  }

  public void moveForward() throws Exception {
    Coordinate coordinate = new Coordinate(this.getPositionX(), this.getPositionX());

    switch (this.direction) {
      case NORTH:
        coordinate = new Coordinate(this.getPositionX(), this.getPositionY() + 1);
        break;
      case EAST:
        coordinate = new Coordinate(this.getPositionX() + 1, this.getPositionY());
        break;
      case SOUTH:
        coordinate = new Coordinate(this.getPositionX(), this.getPositionY() - 1);
        break;
      case WEST:
        coordinate = new Coordinate(this.getPositionX() - 1, this.getPositionY());
        break;
    }

    if (mesh.isCoordinateEmpty(coordinate)) {
      this.positionX = coordinate.getX();
      this.positionY = coordinate.getY();
    } 
  }
}
