package org.gujavasc.webservice.event;

import java.lang.reflect.Field;

import javax.json.stream.JsonGenerator;

public class AbstractEntityResource {


	public AbstractEntityResource() {
	}
	
	public void write(JsonGenerator jsonContent){
				
		Field[] fields = this.getClass().getDeclaredFields();
		jsonContent.writeStartObject();
		for(Field field : fields){
			field.setAccessible(true);
			try {
				jsonContent.write(field.getName(),field.get(this).toString());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		jsonContent.writeStartObject("_links")
				.write("self","")
				.write("detail","")
			.writeEnd()
		.writeEnd();
	}
	
}
