package org.gujavasc.opennetworking.event;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.messaging.jmq.io.Status;

@Path("events")
public class EventResource {

	@Inject
	private EventService service;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response findByName(@QueryParam("q") String name) {
		List<Event> allEventsByName = service.findByName(name);

		return Response.ok(allEventsByName).build();
	}

	@GET
	@Path("/{id:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") Long id) {
		Event event = service.findById(id);
		return Response.ok(event).build();
	}

	@POST
	@Path("/{id:[0-9*]}/checkin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkin(@PathParam("id") Long eventId,
			@FormParam("participantId") Long participantId) {
		service.checkin(eventId, participantId);
		return Response.status(Status.ACCEPTED).build();
	}

}
