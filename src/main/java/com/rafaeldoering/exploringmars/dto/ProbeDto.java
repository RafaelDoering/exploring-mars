package com.rafaeldoering.exploringmars.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProbeDto {
  @NotNull(message = "'name' is required")
  private String name;
}
