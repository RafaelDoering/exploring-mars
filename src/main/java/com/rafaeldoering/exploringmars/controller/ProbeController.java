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
  public ResponseEntity<Probe> postProbe(
    @Valid @RequestBody ProbeDto probe
  ) {
    return new ResponseEntity<>(
      probeService.createProbe(probe.getName()),
      HttpStatus.CREATED
    );
  }

  @GetMapping()
  public ResponseEntity<Page<Probe>> getProbes(Pageable pageable) {
    return new ResponseEntity<>(
      probeService.getProbes(pageable),
      HttpStatus.OK
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<Probe> getProbe(
    @PathVariable("id") int id
  ) throws Exception {
    return new ResponseEntity<>(
      probeService.getProbe(id),
      HttpStatus.OK
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Probe> deleteProbe(
    @PathVariable("id") int id
  ) throws Exception {
    return new ResponseEntity<>(
      probeService.deleteProbe(id),
      HttpStatus.OK
    );
  }

  @PostMapping("/{id}/deploy")
  public ResponseEntity<Probe> deployProbe(
    @PathVariable("id") int id,
    @Valid @RequestBody ProbeDeployDto probeDeploy
  ) throws Exception  {
    return new ResponseEntity<>(
        probeService.deployProbe(
        id,
        probeDeploy.getMeshId(),
        probeDeploy.getPositionX(),
        probeDeploy.getPositionY(),
        probeDeploy.getDirection()
      ),
      HttpStatus.OK
    );
  }

  @PostMapping("/{id}/turn-left")
  public ResponseEntity<Probe> turnProbeLeft(
    @PathVariable("id") int id
  ) throws Exception  {
    return new ResponseEntity<>(
      probeService.turnProbeLeft(id),
      HttpStatus.OK
    );
  }

  @PostMapping("/{id}/turn-right")
  public ResponseEntity<Probe> turnProbeRight(
    @PathVariable("id") int id
  ) throws Exception  {
    return new ResponseEntity<>(
      probeService.turnProbeRight(id),
      HttpStatus.OK
    );
  }

  @PostMapping("/{id}/move-forward")
  public ResponseEntity<Probe> moveProbeForward(
    @PathVariable("id") int id
  ) throws Exception  {
    return new ResponseEntity<>(
      probeService.moveProbeForward(id),
      HttpStatus.OK
    );
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
