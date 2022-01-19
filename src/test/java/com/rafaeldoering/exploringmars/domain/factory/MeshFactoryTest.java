package com.rafaeldoering.exploringmars.domain.factory;

import com.rafaeldoering.exploringmars.domain.model.Mesh;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MeshFactoryTest {
  private static final String MESH_NAME = "Mars";
  private MeshFactory commonMeshFactory;

  @BeforeEach
  public void init(){
    this.commonMeshFactory = new CommonMeshFactory();
  }

  @Test
  public void givenValidDataWhenCreateMeshThenReturnMesh() throws Exception {
    Mesh mesh = this.commonMeshFactory.create(MESH_NAME, 10, 10);

    assertSame(10, mesh.getEdgeCoordinate().getX());
    assertSame(10, mesh.getEdgeCoordinate().getY());
    assertSame(MESH_NAME, mesh.getName());
  }
}
