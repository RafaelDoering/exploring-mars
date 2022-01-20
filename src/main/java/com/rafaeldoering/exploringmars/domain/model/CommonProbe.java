package com.rafaeldoering.exploringmars.domain.model;

public class CommonProbe extends CommonEntity implements Probe {
  private String name;
  private CardinalDirection direction;
  
  public CommonProbe(String name) {
    super();
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public CardinalDirection getDirection() {
    return this.direction;
  }

  public void deploy(Mesh mesh, Coordinate coordinate, CardinalDirection orientation) {
    this.direction = orientation;
    super.deploy(mesh, coordinate);
  }

  @Override
  public void turnLeft() {
    Direction direction = new Direction(this.direction);
    direction.turnLeft();
    this.direction = direction.getDirection();
  }

  @Override
  public void turnRight() {
    Direction direction = new Direction(this.direction);
    direction.turnRight();
    this.direction = direction.getDirection();
  }

  @Override
  public void moveForward() throws Exception {
    Coordinate coordinate = new Coordinate(this.getCoordinates().getX(), this.getCoordinates().getY());

    switch (this.direction) {
      case NORTH:
        coordinate = new Coordinate(this.getCoordinates().getX(), this.getCoordinates().getY() + 1);
        break;
      case EAST:
        coordinate = new Coordinate(this.getCoordinates().getX() + 1, this.getCoordinates().getY());
        break;
      case SOUTH:
        coordinate = new Coordinate(this.getCoordinates().getX(), this.getCoordinates().getY() - 1);
        break;
      case WEST:
        coordinate = new Coordinate(this.getCoordinates().getX() - 1, this.getCoordinates().getY());
        break;
    }

    super.move(coordinate);
  }
}
