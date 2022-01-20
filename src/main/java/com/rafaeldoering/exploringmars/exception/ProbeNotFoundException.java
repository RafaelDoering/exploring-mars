package com.rafaeldoering.exploringmars.exception;

public class ProbeNotFoundException extends Exception {
  public ProbeNotFoundException() {
    super("Probe not found");
  }
}
