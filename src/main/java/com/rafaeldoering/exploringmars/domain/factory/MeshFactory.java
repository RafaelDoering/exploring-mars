package com.rafaeldoering.exploringmars.domain.factory;

import com.rafaeldoering.exploringmars.domain.model.Mesh;

public interface MeshFactory {
  Mesh create(String name, int edgeX, int edgeY);
}
