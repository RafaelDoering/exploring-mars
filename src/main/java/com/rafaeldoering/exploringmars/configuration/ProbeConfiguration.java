package com.rafaeldoering.exploringmars.configuration;

import com.rafaeldoering.exploringmars.domain.factory.CommonProbeFactory;
import com.rafaeldoering.exploringmars.domain.factory.ProbeFactory;
import com.rafaeldoering.exploringmars.domain.usecase.CreateProbeUseCase;
import com.rafaeldoering.exploringmars.infrastructure.converter.ProbeRestConverter;
import com.rafaeldoering.exploringmars.infrastructure.database.pesistence.ProbePersistance;
import com.rafaeldoering.exploringmars.infrastructure.database.repository.ProbeRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProbeConfiguration {
  @Bean
	public CreateProbeUseCase createProbeUseCase(ProbeRepository probeRepository) {
		return new CreateProbeUseCase(this.probeFactory(), this.probePersistance(probeRepository));
	}

	@Bean
	public ProbeFactory probeFactory() {
		return new CommonProbeFactory();
	}

  @Bean
	public ProbeRestConverter probeRestConverter() {
		return new ProbeRestConverter();
	}

  @Bean
  public ProbePersistance probePersistance(ProbeRepository probeRepository){
    return new ProbePersistance(probeRepository);
  }
}
