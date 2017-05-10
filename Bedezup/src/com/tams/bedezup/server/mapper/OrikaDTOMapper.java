package com.tams.bedezup.server.mapper;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import org.springframework.stereotype.Component;

@Component
public class OrikaDTOMapper extends BaseMapperFactory {
	
	
	public OrikaDTOMapper() {
		super();
	}

	@SuppressWarnings("unchecked")
	public void mapObjectToObjectDTO(Object object, Class <?> objectClass, Object objectDTO, Class <?> objectDTOClass) {
		getMapperFactory().classMap(objectClass, objectDTOClass)
		.byDefault()
		.register();
		
		BoundMapperFacade <Object, Object> mapper = (BoundMapperFacade<Object, Object>) getMapperFactory().getMapperFacade(objectClass, objectDTOClass);
		mapper.map(object, objectDTO);
	}
	
	@SuppressWarnings("unchecked")
	public void mapObjectToObjectDTOExcludes(Object object, Class <?> objectClass, Object objectDTO, Class <?> objectDTOClass, String... excludeList) {
		ClassMapBuilder <Object, Object> builder = (ClassMapBuilder<Object, Object>) getMapperFactory().classMap(objectClass, objectDTOClass);
		
		for (String exclude : excludeList) {
			builder.exclude(exclude);
		}
		
		builder.byDefault()
		.register();
		
		BoundMapperFacade <Object, Object> mapper = (BoundMapperFacade<Object, Object>) getMapperFactory().getMapperFacade(objectClass, objectDTOClass);
		mapper.map(object, objectDTO);
	}
}
