package org.gujavasc.opennetworking.project;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
public class ProjectBodyReader implements MessageBodyReader<Project> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return Project.class == type;
	}

	@Override
	public Project readFrom(Class<Project> type,Type genericType, Annotation[] annotations, 
			MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
			InputStream entityStream) throws IOException, WebApplicationException {
		Project project = new Project();
		JsonParser parser = Json.createParser(entityStream);
		while(parser.hasNext()){
			switch(parser.next()){
				case KEY_NAME:
					String key = parser.getString();
					parser.next();
				switch(key){
				case "id":
					project.setId(parser.getLong());
					break;
				case "name":
					project.setName(parser.getString());
					break;
				}
			default:
				break;
			}
		}		
		return project;
	}
}
