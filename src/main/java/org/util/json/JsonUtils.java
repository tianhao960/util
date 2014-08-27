package org.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;


@Log4j
public class JsonUtils<T> {
	
	public String toJson(T target) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(target);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T toObject(String json, Class<?> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return (T) mapper.readValue(json, clazz);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

}
