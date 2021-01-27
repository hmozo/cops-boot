package com.infoq.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.infoq.orm.jpa.InMemoryUniqueIdGenerator;
import com.infoq.orm.jpa.UniqueIdGenerator;

@Configuration
public class AppConfig {

	@Bean
	public UniqueIdGenerator<UUID> uniqueIdGenerator(){
		return new InMemoryUniqueIdGenerator();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
}
