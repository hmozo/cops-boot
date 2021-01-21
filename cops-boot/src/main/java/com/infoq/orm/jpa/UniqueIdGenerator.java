package com.infoq.orm.jpa;

public interface UniqueIdGenerator<T> {
	T getNextUniqueId();
}
