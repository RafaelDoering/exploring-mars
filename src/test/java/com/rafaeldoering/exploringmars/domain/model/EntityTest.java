package com.rafaeldoering.exploringmars.domain.model;

import com.rafaeldoering.exploringmars.domain.factory.CommonMeshFactory;
import com.rafaeldoering.exploringmars.domain.factory.MeshFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityTest {
  private static final String MESH_NAME = "Mars";
  private Mesh mesh;

  @BeforeEach
  public void init() throws Exception {
    MeshFactory commonMeshFactory = new CommonMeshFactory();
    this.mesh = commonMeshFactory.create(MESH_NAME, 10, 10);
  }

  @Test
  public void givenValidDataWhenInstatiateEntityThenReturnEntity() throws Exception {
    Entity entity = new CommonEntity();

    assertNotNull(entity);
  }

  @Test
  public void givenValidEntityWhenDeployOnMeshThenAddEntityToMesh() throws Exception {    
    Entity entity = new CommonEntity();
    Coordinate coordinate = new Coordinate(0, 1);
    entity.deploy(this.mesh, coordinate);
    
    assertSame(this.mesh, entity.getMesh());
    assertSame(0, entity.getCoordinates().getX());
    assertSame(1, entity.getCoordinates().getY());
  }

  @Test
  public void givenOverlapingEntityWhenDeployOnMeshThenThrownError() throws Exception {    
    try {
      Entity entity1 = new CommonEntity();
      Coordinate coordinate1 = new Coordinate(0, 1);
      entity1.deploy(this.mesh, coordinate1);

      Entity entity2 = new CommonEntity();
      Coordinate coordinate2 = new Coordinate(0, 1);
      entity2.deploy(this.mesh, coordinate2);
    } catch (Exception error){
      assertSame("Deploy overlap another entity", error.getMessage());
    }
  }

  @Test
  public void givenValidMoveWhenMoveOnMeshThenMoveEntityToMesh() throws Exception {    
    Entity entity = new CommonEntity();
    Coordinate coordinate1 = new Coordinate(0, 1);
    entity.deploy(this.mesh, coordinate1);
    Coordinate coordinate2 = new Coordinate(1, 1);
    entity.deploy(this.mesh, coordinate2);

    assertSame(1, entity.getCoordinates().getX());
    assertSame(1, entity.getCoordinates().getY());
  }

  @Test
  public void givenMoveWhenMoveOnNotEmptyPositionThenThrownError() throws Exception {    
    try {
      Entity entity1 = new CommonEntity();
      Coordinate coordinate1 = new Coordinate(0, 1);
      entity1.deploy(this.mesh, coordinate1);

      Entity entity2 = new CommonEntity();
      Coordinate coordinate2 = new Coordinate(1, 1);
      entity2.deploy(this.mesh, coordinate2);
      entity2.deploy(this.mesh, coordinate1);
    } catch (Exception error){
      assertSame("This move colides with another enity", error.getMessage());
    }
  }
}
