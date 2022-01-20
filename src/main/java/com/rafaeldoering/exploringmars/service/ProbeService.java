package com.rafaeldoering.exploringmars.service;

import java.util.Optional;

import com.rafaeldoering.exploringmars.exception.ProbeNotFoundException;
import com.rafaeldoering.exploringmars.model.CardinalDirection;
import com.rafaeldoering.exploringmars.model.Coordinate;
import com.rafaeldoering.exploringmars.model.Mesh;
import com.rafaeldoering.exploringmars.model.Probe;
import com.rafaeldoering.exploringmars.repository.ProbeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProbeService {
  @Autowired
  ProbeRepository probeRepository;

  @Autowired
  MeshService meshService;

  public Probe createProbe(String name) {
    Probe probe = new Probe(name);
    probeRepository.save(probe);

    return probe;
  }

  public Page<Probe> getProbes(Pageable pageable) {
    return probeRepository.findAll(pageable);
  }

  public Probe getProbe(int id) throws Exception {
    Optional<Probe> probe = probeRepository.findById(id);

    if (probe.isEmpty()) {
      throw new ProbeNotFoundException();
    }

    return probe.get();
  }

  public Probe deleteProbe(int id) throws Exception {
    Probe probe = this.getProbe(id);

    probeRepository.deleteById(probe.getId());

    return probe;
  }

  public Probe deployProbe(
    int probeId,
    int meshId,
    int positionX,
    int positionY,
    CardinalDirection direction
  ) throws Exception {
    Probe probe = this.getProbe(probeId);
    Mesh mesh = meshService.getMesh(meshId);
    Coordinate coordinate = new Coordinate(positionX, positionY);

    probe.deploy(mesh, coordinate, direction);
    probeRepository.save(probe);

    return probe;
  }

  public Probe turnProbeLeft(int probeId) throws Exception {
    Probe probe = this.getProbe(probeId);
    probe.turnLeft();
    probeRepository.save(probe);

    return probe;
  }

  public Probe turnProbeRight(int probeId) throws Exception {
    Probe probe = this.getProbe(probeId);
    probe.turnRight();
    probeRepository.save(probe);

    return probe;
  }

  public Probe moveProbeForward(int probeId) throws Exception {
    Probe probe = this.getProbe(probeId);
    probe.moveForward();
    probeRepository.save(probe);

    return probe;
  }
}
