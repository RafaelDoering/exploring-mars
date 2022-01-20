package com.rafaeldoering.exploringmars.repository;

import com.rafaeldoering.exploringmars.model.Probe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbeRepository extends JpaRepository<Probe, Integer> {
}
