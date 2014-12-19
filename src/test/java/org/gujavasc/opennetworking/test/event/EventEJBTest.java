package org.gujavasc.opennetworking.test.event;

import java.util.List;

import javax.ejb.EJBException;
import javax.inject.Inject;

import junit.framework.Assert;

import org.gujavasc.opennetworking.event.Event;
import org.gujavasc.opennetworking.event.EventService;
import org.gujavasc.opennetworking.event.Participant;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EventEJBTest {
	
	@Inject
	private EventService service;
	
	private Long eventIdWithParticipants = 1L;
	private Long eventIdEmptyParticipants = 4L;

	@Deployment
    public static Archive<?> createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
            .addPackage(Event.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("data-load.sql","META-INF/data-load.sql")
            .addAsWebInfResource("jbossas-ds.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        return war;
    }
	
	@Test
	public void shouldRegisterParticipantInEvent(){
		service.checkin(eventIdEmptyParticipants, 1L);
	}
	
	@Test(expected=EJBException.class)
	public void shouldNotCheckinEventParticipantChecked(){
		service.checkin(eventIdWithParticipants, 2L);
	}
	
	@Test(expected=EJBException.class)
	public void shouldNotCheckoutEventPartipantNotChecked(){
		service.checkout(eventIdWithParticipants, 4L);
	}
	
	@Test
	public void shouldCheckoutParticipantEvent(){
		service.checkout(eventIdWithParticipants, 1L);
	}
	
	@Test
	public void shouldFindParticipantWithSkill(){
		List<Participant> participantsFound = service.findParticipantsBySkill(eventIdWithParticipants, "Java");
		Assert.assertEquals(2,participantsFound.size());
	}
	
	
}
