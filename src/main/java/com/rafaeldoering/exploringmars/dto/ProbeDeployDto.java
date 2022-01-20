package com.rafaeldoering.exploringmars.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProbeDeployDto {
  @NotNull(message = "'meshId' is required")
  private int meshId;

  @NotNull(message = "'positionX' is required")
  @Min(value = 0, message = "'positionX' must be greater than 0")
  private int positionX;

  @NotNull(message = "'positionY' is required")
  @Min(value = 0, message = "'positionY' must be greater than 0")
  private int positionY;

  @NotNull(message = "'position' is required")
  @Pattern(regexp = "[NESW]", message = "'position' must be 'N', 'E', 'S' or 'W'")
  private String position;
}
