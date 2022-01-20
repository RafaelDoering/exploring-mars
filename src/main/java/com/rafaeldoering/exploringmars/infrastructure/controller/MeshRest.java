package com.rafaeldoering.exploringmars.infrastructure.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeshRest {
  @JsonProperty("name")
  private String name;

  @JsonProperty("edgeX")
  private int edgeX;

  @JsonProperty("edgeY")
  private int edgeY;

  public MeshRest(String name, int edgeX, int edgeY) {
    this.name = name;
    this.edgeX = edgeX;
    this.edgeY = edgeY;
  }

  public String getName() {
    return name;
  }

  public int getEdgeX() {
    return edgeX;
  }

  public int getEdgeY() {
    return edgeY;
  }
}
