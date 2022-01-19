package com.rafaeldoering.exploringmars.domain.model;

public class Coordinate {
  private int x;
  private int y;

  public Coordinate(int x, int y) throws Exception {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public void setX(int x) throws Exception {
    if (x < 0) {
        throw new Exception("X coordinate can only be a positive value");
    } else {
        this.x = x;
    }
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) throws Exception {
    if (y < 0) {
        throw new Exception("Y coordinate can only be a positive value");
    } else {
        this.y = y;
    }
  }
}
