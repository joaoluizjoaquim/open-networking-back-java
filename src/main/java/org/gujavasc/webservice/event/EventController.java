package org.gujavasc.webservice.event;

import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("events")
public class EventController{

	@Inject
	private EventService service;
	
	@GET
	public List<Event> findByName(@NotNull @QueryParam("q") String name){
		return service.findByName(name);
	}
	
}
