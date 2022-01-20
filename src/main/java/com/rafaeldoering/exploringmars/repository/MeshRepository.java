package com.rafaeldoering.exploringmars.repository;

import com.rafaeldoering.exploringmars.model.Mesh;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeshRepository extends JpaRepository<Mesh, Integer> {
}
