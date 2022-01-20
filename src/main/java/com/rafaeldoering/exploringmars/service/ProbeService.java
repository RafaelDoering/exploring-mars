package com.rafaeldoering.exploringmars.service;

import java.util.Optional;

import com.rafaeldoering.exploringmars.exception.ProbeNotFoundException;
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
    Optional<Probe> probe = probeRepository.findById(id);

    if (probe.isEmpty()) {
      throw new ProbeNotFoundException();
    }

    probeRepository.deleteById(id);

    return probe.get();
  }

  // public Probe moveProbe(Long id, String commands) {
  //   Probe probe = getProbe(id);
  //   Mesh mesh = probe.getMesh();

  //   List<Probe> probesInThisMesh = probeRepository.findByMesh(probe.getMesh());

  //   for (int i = 0; i < commands.length(); i++) {
  //     if (commands.charAt(i) == 'L' || commands.charAt(i) == 'R') {
  //       probe.setOrientation(
  //           String.valueOf(getOrientationOnRotation(probe.getOrientation().charAt(0), commands.charAt(i))));
  //     } else {
  //       Position position = new Position(probe.getPositionX(), probe.getPositionY());
  //       position.move(probe.getOrientation().charAt(0));

  //       if (position.getX() < 0 || position.getY() < 0 || position.getX() > mesh.getSizeX() - 1
  //           || position.getY() > mesh.getSizeY() - 1) {
  //         throw new OutOfBoundsException();
  //       }

  //       probe.setPositionX(position.getX());
  //       probe.setPositionY(position.getY());

  //       probesInThisMesh.forEach((probeInThisMesh) -> {
  //         if (!probe.getId().equals(probeInThisMesh.getId())
  //             && (probe.getPositionX().equals(probeInThisMesh.getPositionX())
  //                 && probe.getPositionY().equals(probeInThisMesh.getPositionY()))) {
  //           throw new OccupiedPositionException();
  //         }
  //       });
  //     }
  //   }

  //   return probeRepository.save(probe);
  // }

  // private Character getOrientationOnRotation(Character actualOrientation, Character rotation) {
  //   List<Character> coordinates = new ArrayList<>();

  //   coordinates.add('N');
  //   coordinates.add('E');
  //   coordinates.add('S');
  //   coordinates.add('W');

  //   int actualOrientationIndex = coordinates.indexOf(actualOrientation);
  //   if (rotation == 'L') {
  //     actualOrientationIndex = actualOrientationIndex - 1;
  //     if (actualOrientationIndex < 0) {
  //       actualOrientationIndex = actualOrientationIndex + coordinates.size();
  //     }
  //   } else if (rotation == 'R') {
  //     actualOrientationIndex = actualOrientationIndex + 1;
  //     if (actualOrientationIndex >= coordinates.size()) {
  //       actualOrientationIndex = actualOrientationIndex - coordinates.size();
  //     }
  //   }

  //   return coordinates.get(actualOrientationIndex);
  // }
}
