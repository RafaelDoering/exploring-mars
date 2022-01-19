package com.rafaeldoering.exploringmars.domain.model;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class MeshTest {
  private static final String MESH_NAME = "Mars";

  @Test
  public void givenValidDataWhenInstatiateMeshThenReturnMesh() throws Exception {
    Coordinate edgeCoordinate = new Coordinate(10, 10);
    Mesh mesh = new CommonMesh(MESH_NAME, edgeCoordinate);

    assertSame(10, mesh.getEdgeCoordinate().getX());
    assertSame(10, mesh.getEdgeCoordinate().getY());
    assertSame(MESH_NAME, mesh.getName());
  }

  @Test
  public void givenValiCoordinateWhenIsCoordinateEmptyThenReturnTrue() throws Exception {
    Coordinate edgeCoordinate = new Coordinate(10, 10);
    Mesh mesh = new CommonMesh(MESH_NAME, edgeCoordinate);

    Coordinate coordinate = new Coordinate(0, 0);

    assertSame(true, mesh.isCoordinateEmpty(coordinate));
  }

  @Test
  public void givenOutOfBoundsCoordinateWhenIsCoordinateEmptyThenThrownError() throws Exception {
    Coordinate edgeCoordinate = new Coordinate(10, 10);
    Mesh mesh = new CommonMesh(MESH_NAME, edgeCoordinate);

    Coordinate coordinate = new Coordinate(11, 11);

    try {
      mesh.isCoordinateEmpty(coordinate);
    } catch (Exception error){
      assertSame("Out of Bounds", error.getMessage());
    }
  }
}
