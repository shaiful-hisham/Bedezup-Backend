package com.tams.bedezup.server.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public abstract class BaseMapperFactory {

	private static MapperFactory mapperFactory;
	
	
	public BaseMapperFactory() {
		if (mapperFactory == null) {
			mapperFactory = new DefaultMapperFactory.Builder().build();
		}
	}
	
	public MapperFactory getMapperFactory() {
		return mapperFactory;
	}
}
