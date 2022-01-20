package com.rafaeldoering.exploringmars.infrastructure.database.repopsitory;

import com.rafaeldoering.exploringmars.infrastructure.database.model.MeshData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeshRepository extends JpaRepository<MeshData, Integer> {
  
}
