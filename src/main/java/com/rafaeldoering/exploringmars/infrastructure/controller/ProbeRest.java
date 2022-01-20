package com.rafaeldoering.exploringmars.infrastructure.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProbeRest {
  @JsonProperty("name")
  private String name;

  public ProbeRest() {
  }

  public ProbeRest(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
