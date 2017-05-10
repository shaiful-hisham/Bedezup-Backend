package com.tams.bedezup.server.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Component
public class RestJsonMapper {

	// Json serialize / deserialize operations
	public String toJson(Object object) {
		return new JSONSerializer().prettyPrint(true).exclude("*.class").serialize(object);
	}
	
	public String toJsonExcludes(Object object, String... excludeList) {
		JSONSerializer jsonSerializer = new JSONSerializer();
		jsonSerializer.prettyPrint(true);
		jsonSerializer.exclude("*.class");
		
		for (String exclude : excludeList) {
			jsonSerializer.exclude(exclude);
		}
	
		return jsonSerializer.serialize(object);
	}
	
	public Object fromJsonToObject(String json, Class <?> objectClass) {
        return new JSONDeserializer<Object>().use(null, objectClass).deserialize(json);
    }
	
	public String toJsonArray(Collection <?> collection) {
        return new JSONSerializer().prettyPrint(true).exclude("*.class").serialize(collection);
    }
	
	public Collection <?> fromJsonArrayToObject(String json, Class <?> objectClass) {
		return new JSONDeserializer<List <?>>().use(null, ArrayList.class).use("values", objectClass).deserialize(json);
	}
}
