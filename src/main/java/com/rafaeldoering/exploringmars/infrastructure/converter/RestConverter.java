package com.rafaeldoering.exploringmars.infrastructure.converter;

public interface RestConverter<R, E> {
	R mapToRest(final E entity);
}