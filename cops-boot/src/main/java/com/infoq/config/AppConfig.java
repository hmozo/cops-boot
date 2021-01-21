package com.infoq.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infoq.orm.jpa.InMemoryUniqueIdGenerator;
import com.infoq.orm.jpa.UniqueIdGenerator;

@Configuration
public class AppConfig {

	@Bean
	public UniqueIdGenerator<UUID> uniqueIdGenerator(){
		return new InMemoryUniqueIdGenerator();
	}
}
