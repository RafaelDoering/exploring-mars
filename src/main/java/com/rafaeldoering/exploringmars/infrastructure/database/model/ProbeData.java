package com.rafaeldoering.exploringmars.infrastructure.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rafaeldoering.exploringmars.domain.model.CardinalDirection;

@Entity
@Table(name = "probes")
public class ProbeData extends BaseModelData {
  @Id
  @GeneratedValue
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "x_position")
  private int xPosition;

  @Column(name = "y_position")
  private int yPosition;

  @Column(name = "position")
  @Enumerated(EnumType.STRING)
  private CardinalDirection position;

  @ManyToOne
  @JoinColumn(name = "mesh_id")
  private MeshData mesh;

  public ProbeData() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getxPosition() {
    return xPosition;
  }

  public void setxPosition(int xPosition) {
    this.xPosition = xPosition;
  }

  public int getyPosition() {
    return yPosition;
  }

  public void setyPosition(int yPosition) {
    this.yPosition = yPosition;
  }

  public CardinalDirection getPosition() {
    return position;
  }

  public void setPosition(CardinalDirection position) {
    this.position = position;
  }
}
