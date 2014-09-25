package org.gujavasc.webservice.event;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("events")
public class EventController{

	@Inject
	private EventService service;
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public EventEntityResource findByName(@QueryParam("q") String name){
//		List<Event> allEventsByName = service.findByName(name);
		List<Event> allEventsByName = new ArrayList<>();
		allEventsByName.add(new Event(1,"teste"));
		allEventsByName.add(new Event(2,"teste 2"));
		allEventsByName.add(new Event(3,"teste 3"));
		EventEntityResource eventEntityResource = new EventEntityResource(allEventsByName);
		return eventEntityResource;
	}
	
	@GET
	@Path("/{id[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") Long id){
		return Response.ok().build();
	}
	
}
