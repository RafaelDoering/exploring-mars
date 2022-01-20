package com.rafaeldoering.exploringmars.configuration;

import com.rafaeldoering.exploringmars.domain.factory.CommonMeshFactory;
import com.rafaeldoering.exploringmars.domain.factory.MeshFactory;
import com.rafaeldoering.exploringmars.domain.usecase.CreateMeshUseCase;
import com.rafaeldoering.exploringmars.infrastructure.converter.MeshRestConverter;
import com.rafaeldoering.exploringmars.infrastructure.database.pesistence.MeshPersistance;
import com.rafaeldoering.exploringmars.infrastructure.database.repository.MeshRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MeshConfiguration {
  @Bean
	public CreateMeshUseCase createMeshUseCase(MeshRepository meshRepository) {
		return new CreateMeshUseCase(this.meshFactory(), this.meshPersistance(meshRepository));
	}

	@Bean
	public MeshFactory meshFactory() {
		return new CommonMeshFactory();
	}

  @Bean
	public MeshRestConverter meshRestConverter() {
		return new MeshRestConverter();
	}

  @Bean
  public MeshPersistance meshPersistance(MeshRepository meshRepository){
    return new MeshPersistance(meshRepository);
  }
}
