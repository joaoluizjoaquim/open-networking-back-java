package org.gujavasc.webservice.event;

import java.io.OutputStream;
import java.lang.reflect.Field;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class AbstractEntityResource<T> {

	protected T entity;

	public AbstractEntityResource() {
	}

	public AbstractEntityResource(T entity) {
		this.entity = entity;
	}
	
	public void write(OutputStream stream){
		JsonGenerator gen = Json.createGenerator(stream);
		JsonGenerator genContent = gen.writeStartObject().writeStartArray("content");
				
		Field[] fields = entity.getClass().getDeclaredFields();
		genContent.writeStartObject();
		for(Field field : fields){
			field.setAccessible(true);
			try {
				genContent.write(field.getName(),field.get(entity).toString());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		genContent.writeEnd();
		
		gen.writeEnd().writeEnd();
        gen.flush();
	}
	
}
