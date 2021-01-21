package com.infoq.user;

import java.util.UUID;

import com.infoq.orm.jpa.UniqueIdGenerator;

public class UserRepositoryImpl implements UserRepositoryCustom{

	private final UniqueIdGenerator<UUID> generator; 
	
	public UserRepositoryImpl(UniqueIdGenerator generator) {
		this.generator= generator;
	}
	
	@Override
	public  UserId nextId() {
		return new UserId(generator.getNextUniqueId());
	}

}
