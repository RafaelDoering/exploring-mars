package com.rafaeldoering.exploringmars.infrastructure.converter;

import com.rafaeldoering.exploringmars.domain.model.Mesh;
import com.rafaeldoering.exploringmars.infrastructure.controller.MeshRest;

public class MeshRestConverter implements RestConverter<MeshRest, Mesh>  {
	@Override
	public MeshRest mapToRest(final Mesh entity) {
		return new MeshRest(
			entity.getName(),
			entity.getEdgeCoordinate().getX(),
			entity.getEdgeCoordinate().getY()
		);
	}
}
