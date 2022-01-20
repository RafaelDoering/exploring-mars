package com.rafaeldoering.exploringmars.infrastructure.database.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meshs")
public class MeshData extends BaseModelData {
  @Id
  @GeneratedValue
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "edge_x")
  private int edgeX;

  @Column(name = "edge_y")
  private int edgeY;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesh")
  private Set<ProbeData> probes = new HashSet<>();

  public MeshData() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getEdgeX() {
    return edgeX;
  }

  public void setEdgeX(int edgeX) {
    this.edgeX = edgeX;
  }

  public int getEdgeY() {
    return edgeY;
  }

  public void setEdgeY(int edgeY) {
    this.edgeY = edgeY;
  }
}
