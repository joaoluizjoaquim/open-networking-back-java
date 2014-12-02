package org.gujavasc.opennetworking.test.event;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import junit.framework.Assert;

import org.junit.Test;

public class EventIntegrationTest {

	@Test
	public void sample(){
		Response response = ClientBuilder.newClient()
				.target("http://localhost:8080")
				.path("/open-networking-back-java")
				.path("/events")
				.queryParam("q", "event")
				.request().get();
		Assert.assertEquals(Status.OK, response.getStatus());
	}
	
}
