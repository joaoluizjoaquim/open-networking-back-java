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
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EventEJBTest {
	
	@Inject
	private EventService service;

	private long eventId = 1L;

	private long participantId = 1L;

	@Deployment
    public static Archive<?> createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
            .addPackage(Event.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource("jbossas-ds.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        return war;
    }
	
	@Test
	@InSequence(1)
	@UsingDataSet("simple_event.yml")
	@Cleanup()
	public void shouldFindEventById(){
		Event event = service.findById(eventId);
		Assert.assertNotNull(event);
	}
	
	@Test
	@InSequence(2)
	@UsingDataSet({"simple_event.yml","simple_participant.yml"})
	@Cleanup(phase = TestExecutionPhase.BEFORE)
	public void shouldRegisterParticipantInEvent(){
		service.checkin(eventId, participantId);
		Event event = service.findById(eventId);
		Assert.assertEquals(Long.valueOf(1L), event.getTotalParticipants());
	}
	
	@Test(expected = EJBException.class)
	@InSequence(3)
	@UsingDataSet({"event_participant.yml"})
	@Ignore
	/**
	 * https://developer.jboss.org/thread/235569
	 * https://issues.jboss.org/browse/ARQ-1842
	 * Bug in arquillian Transaction 
	 */
	public void shouldNotCheckinEventParticipantChecked(){
		service.checkin(eventId, participantId);
	}
	
	@Test(expected = EJBException.class)
	@InSequence(4)
	@UsingDataSet({"simple_event.yml","simple_participant.yml"})
	@Ignore
	/**
	 * https://developer.jboss.org/thread/235569
	 * https://issues.jboss.org/browse/ARQ-1842
	 * Bug in arquillian Transaction 
	 */
	public void shouldNotCheckoutEventPartipantNotChecked(){
			service.checkout(eventId, participantId);
	}
	
	@Test
	@InSequence(5)
	@UsingDataSet({"event_participant.yml"})
	@Ignore
	/**
	 * https://developer.jboss.org/thread/235569
	 * https://issues.jboss.org/browse/ARQ-1842
	 * Bug in arquillian Transaction 
	 */
	public void shouldCheckoutParticipantEvent(){
		service.checkout(eventId, participantId);
		Event event = service.findById(eventId);
		Assert.assertEquals(Long.valueOf(0L), event.getTotalParticipants());
	}
	
	@Test
	@InSequence(6)
	@Ignore
	public void shouldFindParticipantWithSkill(){
		List<Participant> participantsFound = service.findParticipantsBySkill(eventId, "Java");
		Assert.assertEquals(2,participantsFound.size());
	}
		
}
