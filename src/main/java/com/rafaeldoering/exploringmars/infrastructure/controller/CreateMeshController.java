package com.rafaeldoering.exploringmars.infrastructure.controller;

import com.rafaeldoering.exploringmars.domain.usecase.CreateMeshUseCase;
import com.rafaeldoering.exploringmars.infrastructure.converter.MeshRestConverter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meshs")
public class CreateMeshController {
  private final CreateMeshUseCase createMeshUseCase;
  private final MeshRestConverter meshRestConverter;

  public CreateMeshController(CreateMeshUseCase createMeshUseCase, MeshRestConverter meshRestConverter) {
    this.createMeshUseCase = createMeshUseCase;
    this.meshRestConverter = meshRestConverter;
  }

  @PostMapping
  public MeshRest create(@RequestBody MeshRest mesh){
    return this.meshRestConverter.mapToRest(
      createMeshUseCase.execute(mesh.getName(), mesh.getEdgeX(), mesh.getEdgeY())
    );
  }
}
