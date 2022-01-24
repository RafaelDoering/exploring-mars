package com.rafaeldoering.exploringmars.controller;

import javax.validation.Valid;

import com.rafaeldoering.exploringmars.dto.ProbeDeployDto;
import com.rafaeldoering.exploringmars.dto.ProbeDto;
import com.rafaeldoering.exploringmars.exception.InvalidLocationException;
import com.rafaeldoering.exploringmars.exception.MeshNotFoundException;
import com.rafaeldoering.exploringmars.exception.ProbeNotFoundException;
import com.rafaeldoering.exploringmars.lib.ExceptionResponse;
import com.rafaeldoering.exploringmars.model.Probe;
import com.rafaeldoering.exploringmars.service.ProbeService;

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
@RequestMapping("/probes")
public class ProbeController {
  @Autowired
  private ProbeService probeService;

  @PostMapping()
  public Probe postProbe(@Valid @RequestBody ProbeDto probe) {
    return probeService.createProbe(probe.getName());
  }

  @GetMapping()
  public Page<Probe> getProbes(Pageable pageable) {
    return probeService.getProbes(pageable);
  }

  @GetMapping("/{id}")
  public Probe getProbe(@PathVariable("id") int id) throws Exception {
    return probeService.getProbe(id);
  }

  @DeleteMapping("/{id}")
  public Probe deleteProbe(@PathVariable("id") int id) throws Exception {
    return probeService.deleteProbe(id);
  }

  @PostMapping("/{id}/deploy")
  public Probe deployProbe(@PathVariable("id") int id, @Valid @RequestBody ProbeDeployDto probeDeploy) throws Exception  {
    return probeService.deployProbe(
      id,
      probeDeploy.getMeshId(),
      probeDeploy.getPositionX(),
      probeDeploy.getPositionY(),
      probeDeploy.getDirection()
    );
  }

  @PostMapping("/{id}/turn-left")
  public Probe turnProbeLeft(@PathVariable("id") int id) throws Exception  {
    return probeService.turnProbeLeft(id);
  }

  @PostMapping("/{id}/turn-right")
  public Probe turnProbeRight(@PathVariable("id") int id) throws Exception  {
    return probeService.turnProbeRight(id);
  }

  @PostMapping("/{id}/move-forward")
  public Probe moveProbeForward(@PathVariable("id") int id) throws Exception  {
    return probeService.moveProbeForward(id);
  }

  @ExceptionHandler(ProbeNotFoundException.class)
  public ResponseEntity<ExceptionResponse> probeNotFound(Exception exception) {
    ExceptionResponse response = new ExceptionResponse(
      HttpStatus.NOT_FOUND.value(),
      exception.getMessage()
    );

    return new ResponseEntity<ExceptionResponse>(
      response,
      HttpStatus.valueOf(response.getStatusCode())
    );
  }

  @ExceptionHandler(InvalidLocationException.class)
  public ResponseEntity<ExceptionResponse> invalidLocation(Exception exception) {
    ExceptionResponse response = new ExceptionResponse(
      HttpStatus.BAD_REQUEST.value(),
      exception.getMessage()
    );

    return new ResponseEntity<ExceptionResponse>(
      response,
      HttpStatus.valueOf(response.getStatusCode())
    );
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
