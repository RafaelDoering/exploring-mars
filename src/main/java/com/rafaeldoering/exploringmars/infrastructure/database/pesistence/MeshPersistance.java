package com.rafaeldoering.exploringmars.infrastructure.database.pesistence;

import com.rafaeldoering.exploringmars.infrastructure.database.model.MeshData;
import com.rafaeldoering.exploringmars.infrastructure.database.repository.MeshRepository;

public class MeshPersistance {
  private final MeshRepository meshRepository;

  public MeshPersistance(MeshRepository meshRepository) {
    this.meshRepository = meshRepository;
  }

  public int save(String name, int edgeX, int edgeY) {
    MeshData mesh = new MeshData();

    mesh.setName(name);
    mesh.setEdgeX(edgeX);
    mesh.setEdgeY(edgeY);

    this.meshRepository.save(mesh);

    return mesh.getId();
  }
}
