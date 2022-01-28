package com.rafaeldoering.exploringmars.model;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProbeTest {
  private static final String PROBE_NAME = "Curiosity";
  private static final String MESH_NAME = "Mars";
  private Mesh mesh;

  @BeforeEach
  public void init() throws Exception {
    this.mesh = new Mesh(MESH_NAME, 10, 10);
  }

  @Test
  public void givenValidDataWhenInstantiateProbeThenReturnProbe() throws Exception {
    Probe probe = new Probe(PROBE_NAME);

    assertSame(PROBE_NAME, probe.getName());
  }

  @Test
  public void givenValidProbeWhenDeployOnMeshThenAddProbeToMesh() throws Exception {    
    Probe probe = new Probe();
    Coordinate coordinate = new Coordinate(0, 0);
    probe.deploy(this.mesh, coordinate, CardinalDirection.NORTH);
    
    assertSame(this.mesh, probe.getMesh());
    assertSame(0, probe.getPositionX());
    assertSame(0, probe.getPositionY());
  }

  @Test
  public void givenOverlapingProbeWhenDeployOnMeshThenThrownError() throws Exception {    
    try {
      Probe probe1 = new Probe();
      Coordinate coordinate1 = new Coordinate(0, 0);
      probe1.deploy(this.mesh, coordinate1, CardinalDirection.NORTH);

      Probe probe2 = new Probe();
      Coordinate coordinate2 = new Coordinate(0, 0);
      probe2.deploy(this.mesh, coordinate2, CardinalDirection.NORTH);
    } catch (Exception error){
      assertSame("Invalid location", error.getMessage());
    }
  }

  @Test
  public void givenValidMoveWhenMoveOnMeshThenMoveProbeToMesh() throws Exception {    
    Probe probe = new Probe();
    Coordinate coordinate1 = new Coordinate(0, 0);
    probe.deploy(this.mesh, coordinate1, CardinalDirection.NORTH);
    Coordinate coordinate2 = new Coordinate(1, 1);
    probe.deploy(this.mesh, coordinate2, CardinalDirection.NORTH);

    assertSame(1, probe.getPositionX());
    assertSame(1, probe.getPositionY());
  }

  @Test
  public void givenValidMoveWhenMoveOnMeshThenMoveProbeInMesh() throws Exception {    
    Probe probe = new Probe(PROBE_NAME);
    Coordinate coordinate1 = new Coordinate(0, 0);
    probe.deploy(this.mesh, coordinate1, CardinalDirection.NORTH);
    probe.moveForward();
    probe.turnRight();
    probe.moveForward();
    probe.moveForward();

    assertSame(2, probe.getPositionX());
    assertSame(1, probe.getPositionY());
  }

  @Test
  public void givenInvalidMoveWhenMoveOnMeshThenThrownError() throws Exception {    
    try {
      Probe probe = new Probe(PROBE_NAME);
      Coordinate coordinate1 = new Coordinate(0, 0);
      probe.deploy(this.mesh, coordinate1, CardinalDirection.WEST);
      probe.moveForward();
    } catch (Exception error){
      assertSame("Invalid location", error.getMessage());
    }
  }

  @Test
  public void givenOutOfBoundsMoveWhenMoveOnMeshThenThrownError() throws Exception {    
    try {
      Probe probe = new Probe(PROBE_NAME);
      Coordinate coordinate1 = new Coordinate(10, 10);
      probe.deploy(this.mesh, coordinate1, CardinalDirection.NORTH);
      probe.moveForward();
    } catch (Exception error){
      assertSame("Invalid location", error.getMessage());
    }
  }
}
