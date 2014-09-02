package javaeetutorial.hello;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
 
@Path("helloworld/")
public class HelloWorld {
 
	@Context
    private UriInfo context;
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHtml() {
        return Response.accepted().build();
    }
}