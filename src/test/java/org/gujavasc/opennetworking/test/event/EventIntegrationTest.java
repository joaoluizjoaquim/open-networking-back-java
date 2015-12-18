package org.gujavasc.opennetworking.test.event;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

public class EventIntegrationTest {

	private String server = "http://localhost:8080";
	private String contextPath = "/open-networking-java-ee";
	private String resourcePath = "/events";
	private String validEventIdPath = "/1";
	private String checkinPath = "/checkin";

	@Test
	public void shouldReturnStatusNotFoundForNonExistentResource(){
		Response response = urlEventResource().path("/100").request().get();
		Assert.assertEquals(Status.NOT_FOUND, Status.fromStatusCode(response.getStatus()));
	}
	
	@Test
	public void shouldCheckinParticipantInEvent(){
		Form form = new Form();
		validParticipantForm(form);
		Response response = urlEventResource()
				.path(validEventIdPath)
				.path(checkinPath)
				.request()
				.post(Entity.form(form));
		Assert.assertEquals(Status.ACCEPTED, Status.fromStatusCode(response.getStatus()));
	}
	
	@Test
	@Ignore
	public void shouldNotCheckinEventParticipantChecked(){
		Form form = new Form();
		invalidParticipantForm(form);
		Response response = urlEventResource()
				.path(validEventIdPath)
				.path(checkinPath)
				.request()
				.post(Entity.form(form));
		Assert.assertEquals(Status.ACCEPTED, Status.fromStatusCode(response.getStatus()));
	}
	
	@Test
	@Ignore
	public void shouldNotCheckoutEventPartipantNotChecked(){
		
	}
	
	@Test
	@Ignore
	public void shouldCheckoutParticipantEvent(){
	}
	
	private WebTarget urlEventResource() {
		return ClientBuilder.newClient().target(server).path(contextPath)
				.path(resourcePath);
	}
	
	private Form validParticipantForm(Form form) {
		return form.param("participantId", "4");
	}
	
	private Form invalidParticipantForm(Form form) {
		return form.param("participantId", "9");
	}
	
}
