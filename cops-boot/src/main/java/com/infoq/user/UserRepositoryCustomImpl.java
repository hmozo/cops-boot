package com.infoq.user;

import java.util.UUID;

import com.infoq.orm.jpa.UniqueIdGenerator;

public class UserRepositoryCustomImpl implements UserRepositoryCustom{

	private final UniqueIdGenerator<UUID> generator; 
	
	public UserRepositoryCustomImpl(UniqueIdGenerator generator) {
		this.generator= generator;
	}
	
	@Override
	public  UserId nextId() {
		return new UserId(generator.getNextUniqueId());
	}

}
