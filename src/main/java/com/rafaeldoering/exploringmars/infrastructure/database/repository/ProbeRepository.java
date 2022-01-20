package com.rafaeldoering.exploringmars.infrastructure.database.repository;

import com.rafaeldoering.exploringmars.infrastructure.database.model.ProbeData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbeRepository extends JpaRepository<ProbeData, Integer> {
  
}
