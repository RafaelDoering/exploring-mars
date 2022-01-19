package com.rafaeldoering.exploringmars.domain.factory;

import com.rafaeldoering.exploringmars.domain.model.Coordinate;
import com.rafaeldoering.exploringmars.domain.model.CommonMesh;
import com.rafaeldoering.exploringmars.domain.model.Mesh;

public class CommonMeshFactory implements MeshFactory {
  @Override
  public Mesh create(String name, int edgeX, int edgeY) throws Exception {
    Coordinate edge = new Coordinate(edgeX, edgeY);
    return new CommonMesh(name, edge);
  }
}
