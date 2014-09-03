package org.gujavasc.webservice.project;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("projects")
public class ProjectEndpoint {

	@Inject
	private ProjectService service;
	
	@GET()
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		return Response.ok(service.getAll()).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Project project){
		service.create(project);
		return Response.ok().build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Project project){
		return Response.accepted(project).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id){
		service.delete(id);
		return Response.ok().build();
	}
	
}
