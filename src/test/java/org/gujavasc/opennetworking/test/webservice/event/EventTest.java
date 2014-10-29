package org.gujavasc.opennetworking.test.webservice.event;

import org.gujavasc.opennetworking.domain.event.Event;
import org.gujavasc.opennetworking.domain.participant.Participant;
import org.junit.Before;
import org.junit.Test;

public class EventTest {

	private Participant participant;
	private Event event;

	@Before
	public void before(){
		participant = new Participant();
		event = new Event();
	}
	
	@Test
	public void shouldCheckinEvent(){
		event.checkin(participant);
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotCheckinEventParticipantChecked(){
		event.checkin(participant);
		event.checkin(participant);
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotCheckoutEventPartipantNotChecked(){
		event.checkout(participant);
	}
	
	@Test
	public void shouldCheckoutParticipantEvent(){
		event.checkin(participant);
		event.checkout(participant);
	}
}
