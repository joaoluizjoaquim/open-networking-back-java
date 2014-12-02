package org.gujavasc.opennetworking.test.event;

import org.gujavasc.opennetworking.event.Event;
import org.gujavasc.opennetworking.event.Participant;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class EventUnitTest {

	private Participant participant;
	private Event eventWithEmptyParticipants;

	@BeforeClass
	public static void preparteObjectFactory(){
		Fixture.of(Event.class).addTemplate("withOneParticipant", new Rule(){{
			add("id", random(Long.class, range(1L, 3L)));
			add("name","event 1");
			add("participants", has(1).of(Participant.class,"first") );
		}});
				
		Fixture.of(Participant.class).addTemplate("first",new Rule(){{
			add("id", 1L);
			add("name", "participant 1");
		}});		
	}
	
	@Before
	public void before(){
		participant = new Participant();
		eventWithEmptyParticipants = new Event();
	}
	
	@Test
	public void shouldRegisterParticipantInEvent(){
		eventWithEmptyParticipants.checkin(participant);
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotCheckinEventParticipantChecked(){
		Event event = Fixture.from(Event.class).gimme("withOneParticipant");
		Participant participant = Fixture.from(Participant.class).gimme("first");
		event.checkin(participant);
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotCheckoutEventPartipantNotChecked(){
		eventWithEmptyParticipants.checkout(participant);
	}
	
	@Test
	public void shouldCheckoutParticipantEvent(){
		Event event = Fixture.from(Event.class).gimme("withOneParticipant");
		Participant participant = Fixture.from(Participant.class).gimme("first");
		event.checkout(participant);
	}
	
}
