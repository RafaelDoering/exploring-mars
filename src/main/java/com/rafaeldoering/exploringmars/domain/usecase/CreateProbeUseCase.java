package com.rafaeldoering.exploringmars.domain.usecase;

import com.rafaeldoering.exploringmars.domain.factory.ProbeFactory;
import com.rafaeldoering.exploringmars.domain.model.Probe;
import com.rafaeldoering.exploringmars.infrastructure.database.pesistence.ProbePersistance;

public class CreateProbeUseCase {
  private final ProbeFactory probeFactory;
  private final ProbePersistance probePersistance;

  public CreateProbeUseCase(ProbeFactory probeFactory, ProbePersistance probePersistance) {
    this.probeFactory = probeFactory;
    this.probePersistance = probePersistance;
  }

  public Probe execute(String name) {
    Probe probe = probeFactory.create(name);
    probePersistance.save(probe.getName());
    return probe;
  }
}
