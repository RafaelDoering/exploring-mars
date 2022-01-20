package com.rafaeldoering.exploringmars.infrastructure.converter;

import com.rafaeldoering.exploringmars.domain.model.Probe;
import com.rafaeldoering.exploringmars.infrastructure.controller.ProbeRest;

public class ProbeRestConverter implements RestConverter<ProbeRest, Probe>  {
	@Override
	public ProbeRest mapToRest(final Probe entity) {
		return new ProbeRest(
			entity.getName()
		);
	}
}
