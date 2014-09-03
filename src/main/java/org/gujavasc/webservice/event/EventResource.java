package org.gujavasc.webservice.event;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("events")
public class EventResource implements EventEndpoint{

	@Inject
	private EventService service;
	
	@GET
	public Response findByName(@NotNull @QueryParam("q") String name){
		return Response.accepted(service.findByName(name)).build();
	}
	
}
