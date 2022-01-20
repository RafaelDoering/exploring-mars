package com.rafaeldoering.exploringmars.domain.factory;

import com.rafaeldoering.exploringmars.domain.model.Probe;

public interface ProbeFactory {
  Probe create(String name);
}
