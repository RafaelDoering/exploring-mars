package com.rafaeldoering.exploringmars.service;

import java.util.Optional;

import com.rafaeldoering.exploringmars.exception.MeshNotFoundException;
import com.rafaeldoering.exploringmars.model.Mesh;
import com.rafaeldoering.exploringmars.repository.MeshRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MeshService {
  @Autowired
  MeshRepository meshRepository;

  public Mesh createMesh(Mesh mesh) {
    meshRepository.save(mesh);
    System.out.println(mesh.getName());

    return mesh;
  }

  public Page<Mesh> getMeshs(Pageable pageable) {
    return meshRepository.findAll(pageable);
  }

  public Mesh getMesh(int id) throws Exception {
    Optional<Mesh> mesh = meshRepository.findById(id);

    if (mesh.isEmpty()) {
      throw new MeshNotFoundException();
    }

    return mesh.get();
  }

  public Mesh deleteMesh(int id) throws Exception {
    Optional<Mesh> mesh = meshRepository.findById(id);

    if (mesh.isEmpty()) {
      throw new MeshNotFoundException();
    }

    meshRepository.deleteById(id);

    return mesh.get();
  }
}
