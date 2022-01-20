package com.rafaeldoering.exploringmars.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.rafaeldoering.exploringmars.model.Mesh;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeshDto {
  @NotNull(message = "'name' is required")
  private String name;

  @NotNull(message = "'edgeX' is required")
  @Min(value = 1, message = "'edgeX' must be greater than 0")
  private int edgeX;

  @NotNull(message = "'edgeY' is required")
  @Min(value = 1, message = "'edgeY' must be greater than 0")
  private int edgeY;

  public static Mesh toMesh(MeshDto meshDto) throws Exception {
    return new Mesh(meshDto.name, meshDto.edgeX, meshDto.edgeY);
  }
}
