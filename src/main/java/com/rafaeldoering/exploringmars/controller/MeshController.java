package com.rafaeldoering.exploringmars.controller;

import javax.validation.Valid;

import com.rafaeldoering.exploringmars.dto.MeshDto;
import com.rafaeldoering.exploringmars.exception.MeshNotFoundException;
import com.rafaeldoering.exploringmars.lib.ExceptionResponse;
import com.rafaeldoering.exploringmars.model.Mesh;
import com.rafaeldoering.exploringmars.service.MeshService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meshs")
public class MeshController {
  @Autowired
  private MeshService meshService;

  @PostMapping()
  public Mesh postMesh(@Valid @RequestBody MeshDto mesh) throws Exception {
    return meshService.createMesh(MeshDto.toMesh(mesh));
  }
  
  @GetMapping()
  public Page<Mesh> getMeshs(Pageable pageable) {
    return meshService.getMeshs(pageable);
  }

  @GetMapping("/{id}")
  public Mesh getMesh(@PathVariable("id") int id) throws Exception {
    return meshService.getMesh(id);
  }

  @DeleteMapping("/{id}")
  public Mesh deleteMesh(@PathVariable("id") int id) throws Exception {
    return meshService.deleteMesh(id);
  }

  @ExceptionHandler(MeshNotFoundException.class)
  public ResponseEntity<ExceptionResponse> meshNotFound(Exception exception) {
    ExceptionResponse response = new ExceptionResponse(
      HttpStatus.NOT_FOUND.value(),
      exception.getMessage()
    );

    return new ResponseEntity<ExceptionResponse>(
      response,
      HttpStatus.valueOf(response.getStatusCode())
    );
  }
}
