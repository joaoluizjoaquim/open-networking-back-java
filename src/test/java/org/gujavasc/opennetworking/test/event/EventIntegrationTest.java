package org.gujavasc.opennetworking.test.event;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import junit.framework.Assert;

import org.junit.Test;

public class EventIntegrationTest {

	private String server = "http://localhost:8080";
	private String contextPath = "/open-networking-back-java";
	private String resourcePath = "/events";

	@Test
	public void shouldReturnStatusNotFoundForNonExistentResource(){
		Response response = urlEventResource().path("/100").request().get();
		Assert.assertEquals(Status.NOT_FOUND, Status.fromStatusCode(response.getStatus()));
	}
	
	@Test
	public void shouldCheckinParticipantInEvent(){
		Form form = new Form();
		form.param("participantId", "4");
		Response response = urlEventResource().path("/1").path("/checkin").request().post(Entity.form(form));
		Assert.assertEquals(Status.ACCEPTED, Status.fromStatusCode(response.getStatus()));
	}
	
	private WebTarget urlEventResource() {
		return ClientBuilder.newClient().target(server).path(contextPath)
				.path(resourcePath);
	}
	
}
