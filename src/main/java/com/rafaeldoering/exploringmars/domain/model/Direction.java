package com.rafaeldoering.exploringmars.domain.model;

public class Direction {
  private CardinalDirection direction;
  
  public Direction(CardinalDirection direction) {
    this.direction = direction;
  }

  public CardinalDirection getDirection() {
    return this.direction;
  }

  public void turnLeft() {
    switch (this.direction) {
      case NORTH:
        this.direction = CardinalDirection.WEST;
        break;
      case EAST:
        this.direction = CardinalDirection.NORTH;
        break;
      case SOUTH:
        this.direction = CardinalDirection.EAST;
        break;
      case WEST:
        this.direction = CardinalDirection.SOUTH;
        break;
    }
  }

  public void turnRight() {
    switch (this.direction) {
      case NORTH:
        this.direction = CardinalDirection.EAST;
        break;
      case EAST:
        this.direction = CardinalDirection.SOUTH;
        break;
      case SOUTH:
        this.direction = CardinalDirection.WEST;
        break;
      case WEST:
        this.direction = CardinalDirection.NORTH;
        break;
    }
  }
}
