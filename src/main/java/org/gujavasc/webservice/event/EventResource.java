package org.gujavasc.webservice.event;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(value=MediaType.APPLICATION_JSON)
public class EventResource implements MessageBodyWriter<EventEntityResource>{

	@Context
	private UriInfo uriInfo;
	
	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return true;
	}

	@Override
	@Deprecated
	public long getSize(EventEntityResource t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public void writeTo(EventEntityResource t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException, WebApplicationException {
		t.write(entityStream);
//		JsonGenerator gen = Json.createGenerator(entityStream);
//		JsonGenerator genContent = gen.writeStartObject().writeStartArray("content");
//				
//		List<Event> events = t.getEvents();
//		for(Event event : events){
//			genContent.writeStartObject()
//				.write("name", event.getName())
//				.write("totalParticipants", event.getTotalPaticipants())
//					.writeStartObject("links")
//						.write("detail",new LinkBuilder(uriInfo)
//											.addPath(EventController.class)
//											.addPath(event.getId())
//											.addQueryParam("param1", "value1")
//											.addQueryParam("param2", "value2")
//											.build())
//					.writeEnd()
//				.writeEnd();
//		}
//		gen.writeEnd().writeEnd();
//        gen.flush();
		
		
		
	}

}
