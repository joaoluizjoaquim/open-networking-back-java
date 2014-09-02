package org.gujavasc.webservice.project;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("projects")
public class ProjectRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		List<Project> projects = new ArrayList<>();
		projects.add(new Project(Long.valueOf(1), "Project 1"));
		projects.add(new Project(Long.valueOf(2), "Project 2"));
		return Response.ok(projects).build();
	}
	
	@POST
	public Response create(Project project){
		return Response.accepted(project).build();
	}
	
}
