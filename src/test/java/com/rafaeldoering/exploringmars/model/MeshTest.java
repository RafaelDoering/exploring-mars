package com.rafaeldoering.exploringmars.model;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

public class MeshTest {
  private static final String MESH_NAME = "Mars";

  @Test
  public void givenValidDataWhenInstatiateMeshThenReturnMesh() throws Exception {
    Mesh mesh = new Mesh(MESH_NAME, 10, 10);

    assertSame(10, mesh.getEdgeX());
    assertSame(10, mesh.getEdgeY());
    assertSame(MESH_NAME, mesh.getName());
  }

  @Test
  public void givenValiCoordinateWhenIsCoordinateEmptyThenReturnTrue() throws Exception {
    Mesh mesh = new Mesh(MESH_NAME, 10, 10);

    Coordinate coordinate = new Coordinate(0, 0);

    assertSame(true, mesh.isCoordinateEmpty(coordinate));
  }

  @Test
  public void givenOutOfBoundsCoordinateWhenIsCoordinateEmptyThenThrownError() throws Exception {
    Mesh mesh = new Mesh(MESH_NAME, 10, 10);

    Coordinate coordinate = new Coordinate(11, 11);

    try {
      mesh.isCoordinateEmpty(coordinate);
    } catch (Exception error){
      assertSame("Out of Bounds", error.getMessage());
    }
  }
}
