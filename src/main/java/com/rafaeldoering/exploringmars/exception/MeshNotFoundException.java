package com.rafaeldoering.exploringmars.exception;

public class MeshNotFoundException extends Exception {
  public MeshNotFoundException() {
    super("Mesh not found");
  }
}
