package org.gujavasc.opennetworking.test.webservice.event;

import javax.inject.Inject;

import junit.framework.Assert;

import org.gujavasc.opennetworking.event.Event;
import org.gujavasc.opennetworking.event.EventService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SampleTest {
	
	@Inject
	private EventService service;

	@Deployment
    public static Archive<?> createDeployment() {
        // You can use war packaging...
        WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war")
            .addPackage(Event.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource("jbossas-ds.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

        return war;
    }
	
	@Test
	public void test(){
		Event event = service.findById(1L);
		Assert.assertTrue(event != null);
	}
 
	
}
