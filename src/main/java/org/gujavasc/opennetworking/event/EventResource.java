package org.gujavasc.opennetworking.event;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("events")
public class EventResource{

	@Inject
	private EventService service;
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public Response findByName(@QueryParam("q") String name){
		List<Event> allEventsByName = service.findByName(name);
		
		return Response.ok(allEventsByName).build();
	}
	
	@GET
	@Path("/{id:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") Long id){
		Event event = service.findById(id);
		return Response.ok(event).build();
	}
	
}
