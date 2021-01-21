package com.infoq.config;

import java.util.UUID;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.infoq.orm.jpa.InMemoryUniqueIdGenerator;
import com.infoq.orm.jpa.UniqueIdGenerator;

@TestConfiguration
public class TestConfig {
	
	@Bean
	public UniqueIdGenerator<UUID> generator(){
		return new InMemoryUniqueIdGenerator();
	}
}
