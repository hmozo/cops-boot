package com.infoq.user;

import java.util.UUID;

import com.infoq.orm.jpa.AbstractEntityId;

public class UserId extends AbstractEntityId<UUID>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected UserId() {
	}
	
	public UserId(UUID id) {
		super(id);
	}
	
	

}
