package org.gujavasc.opennetworking.test.webservice.event;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EventTest {

	private Client client;

	@Before
	public void before(){
		client = ClientBuilder.newClient();
	}
	
	@After
	public void after(){
		client.close();
	}
	
	@Test
	public void testa(){
		Response response = client.target("http://localhost:8080/open-networking-back-java/events/")
				.queryParam("q", "teste")
				.request()
				.get();
		Assert.assertEquals(response.getStatus(), Status.OK.getStatusCode());
	}
	
}
