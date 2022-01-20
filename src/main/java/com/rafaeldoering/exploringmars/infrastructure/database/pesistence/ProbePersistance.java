package com.rafaeldoering.exploringmars.infrastructure.database.pesistence;

import com.rafaeldoering.exploringmars.infrastructure.database.model.ProbeData;
import com.rafaeldoering.exploringmars.infrastructure.database.repository.ProbeRepository;

public class ProbePersistance {
  private final ProbeRepository probeRepository;

  public ProbePersistance(ProbeRepository probeRepository) {
    this.probeRepository = probeRepository;
  }

  public int save(String name) {
    ProbeData probe = new ProbeData();

    probe.setName(name);

    this.probeRepository.save(probe);

    return probe.getId();
  }
}
