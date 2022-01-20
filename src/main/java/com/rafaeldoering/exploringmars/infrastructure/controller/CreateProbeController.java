package com.rafaeldoering.exploringmars.infrastructure.controller;

import com.rafaeldoering.exploringmars.domain.usecase.CreateProbeUseCase;
import com.rafaeldoering.exploringmars.infrastructure.converter.ProbeRestConverter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/probes")
public class CreateProbeController {
  private final CreateProbeUseCase createProbeUseCase;
  private final ProbeRestConverter probeRestConverter;

  public CreateProbeController(CreateProbeUseCase createProbeUseCase, ProbeRestConverter probeRestConverter) {
    this.createProbeUseCase = createProbeUseCase;
    this.probeRestConverter = probeRestConverter;
  }

  @PostMapping
  public ProbeRest create(@RequestBody ProbeRest probe){
    return this.probeRestConverter.mapToRest(
      createProbeUseCase.execute(probe.getName())
    );
  }
}
