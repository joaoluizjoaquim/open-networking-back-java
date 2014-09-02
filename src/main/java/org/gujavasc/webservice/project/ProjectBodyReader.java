package org.gujavasc.webservice.project;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes(value=MediaType.APPLICATION_JSON)
public class ProjectBodyReader implements MessageBodyReader<Project> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return false;
	}

	@Override
	public Project readFrom(Class<Project> type,Type genericType, Annotation[] annotations, 
			MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
			InputStream entityStream) throws IOException, WebApplicationException {
		return null;
	}

}
