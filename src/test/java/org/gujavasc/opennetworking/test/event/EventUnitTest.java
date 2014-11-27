package org.gujavasc.opennetworking.test.event;

import org.gujavasc.opennetworking.event.Event;
import org.gujavasc.opennetworking.participant.Participant;
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
			add("name",random("event 1","event 2", "event 3"));
			add("participants", has(1).of(Participant.class,"first") );
		}});
				
		Fixture.of(Participant.class).addTemplate("first",new Rule(){{
			add("id", 1L);
			add("name", random("participant 1","participant 2", "participant 3") );
		}});
		
		Fixture.of(Participant.class).addTemplate("valid",new Rule(){{
			add("id", random(Long.class, range(1L, 3L)));
			add("name", random("participant 1","participant 2", "participant 3") );
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
