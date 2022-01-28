package com.rafaeldoering.exploringmars.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "meshs")
public class Mesh extends BaseEntity {
  @Column(name = "name")
  private String name;

  @Column(name = "edge_x")
  private int edgeX;

  @Column(name = "edge_y")
  private int edgeY;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesh")
  @JsonIgnoreProperties(value = { "mesh" })
  private Set<Probe> probes = new HashSet<>();

  public Mesh(String name, int xEdge, int yEdge) throws Exception {
    Coordinate edgeCoordinate = new Coordinate(xEdge, yEdge);
    this.name = name;
    this.edgeX = edgeCoordinate.getX();
    this.edgeY = edgeCoordinate.getY();
  }

  public boolean isCoordinateEmpty(Coordinate coordinate) {
    if (isOutOfBounds(coordinate)) {
      return false;
    }
    
    for (Probe probe : this.probes) {
      if (
        coordinate.getX() == probe.getPositionX() &&
        coordinate.getY() == probe.getPositionY()
      ) {
        return false;
      }
    }

    return true;
  }

  public boolean isOutOfBounds(Coordinate coordinate) {
    if (
      coordinate.getX() > this.getEdgeX() ||
      coordinate.getY() > this.getEdgeY() ||
      coordinate.getX() < 0 ||
      coordinate.getY() < 0
    ) {
      return true;
    }

    return false;
  }

  public void addProbe(Probe probe) {
    this.probes.add(probe);
  }

  public void removeProbe(Probe probe) {
    this.probes.remove(probe);
  }
}
