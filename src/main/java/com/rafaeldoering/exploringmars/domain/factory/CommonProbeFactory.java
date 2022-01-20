package com.rafaeldoering.exploringmars.domain.factory;

import com.rafaeldoering.exploringmars.domain.model.CommonProbe;
import com.rafaeldoering.exploringmars.domain.model.Probe;

public class CommonProbeFactory implements ProbeFactory {
  @Override
  public Probe create(String name) {
    try {
      return new CommonProbe(name);
    } catch (Exception error) {
      return null;
    }
  }
}
