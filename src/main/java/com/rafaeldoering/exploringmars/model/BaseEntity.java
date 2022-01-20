package com.rafaeldoering.exploringmars.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;

@Getter
@MappedSuperclass
public class BaseEntity {
  @Id
  @GeneratedValue
  private int id;
}
