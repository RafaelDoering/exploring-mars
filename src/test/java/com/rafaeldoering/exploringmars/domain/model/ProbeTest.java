package com.rafaeldoering.exploringmars.domain.model;

import com.rafaeldoering.exploringmars.domain.factory.CommonMeshFactory;
import com.rafaeldoering.exploringmars.domain.factory.MeshFactory;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProbeTest {
  private static final String PROBE_NAME = "Curiosity";
  private static final String MESH_NAME = "Mars";
  private Mesh mesh;

  @BeforeEach
  public void init() throws Exception {
    MeshFactory commonMeshFactory = new CommonMeshFactory();
    this.mesh = commonMeshFactory.create(MESH_NAME, 10, 10);
  }

  @Test
  public void givenValidDataWhenInstantiatingProbeThenReturnProbe() throws Exception {
    Probe probe = new CommonProbe(PROBE_NAME);

    assertSame(PROBE_NAME, probe.getName());
  }

  @Test
  public void givenValidMoveWhenMoveOnMeshThenMoveProbeInMesh() throws Exception {    
    Probe probe = new CommonProbe(PROBE_NAME);
    Coordinate coordinate1 = new Coordinate(0, 0);
    probe.deploy(this.mesh, coordinate1, CardinalDirection.NORTH);
    probe.moveForward();
    probe.turnRight();
    probe.moveForward();
    probe.moveForward();

    assertSame(2, probe.getCoordinates().getX());
    assertSame(1, probe.getCoordinates().getY());
  }
}
