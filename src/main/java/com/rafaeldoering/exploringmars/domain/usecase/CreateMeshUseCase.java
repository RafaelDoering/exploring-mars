package com.rafaeldoering.exploringmars.domain.usecase;

import com.rafaeldoering.exploringmars.domain.factory.MeshFactory;
import com.rafaeldoering.exploringmars.domain.model.Mesh;
import com.rafaeldoering.exploringmars.infrastructure.database.pesistence.MeshPersistance;

public class CreateMeshUseCase {
  private final MeshFactory meshFactory;
  private final MeshPersistance meshPersistance;

  public CreateMeshUseCase(MeshFactory meshFactory, MeshPersistance meshPersistance) {
    this.meshFactory = meshFactory;
    this.meshPersistance = meshPersistance;
  }

  public Mesh execute(String name, int edgeX, int edgeY) {
    Mesh mesh = meshFactory.create(name, edgeX, edgeY);
    meshPersistance.save(mesh.getName(), mesh.getEdgeCoordinate().getX(), mesh.getEdgeCoordinate().getY());
    return mesh;
  }
}
