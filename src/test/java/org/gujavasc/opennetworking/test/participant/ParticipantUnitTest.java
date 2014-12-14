package org.gujavasc.opennetworking.test.participant;

import org.gujavasc.opennetworking.event.Event;
import org.gujavasc.opennetworking.event.Participant;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class ParticipantUnitTest {

	private Participant participant;
	private Event eventWithEmptyParticipants;

	@BeforeClass
	public static void preparteObjectFactory(){
		Fixture.of(Participant.class).addTemplate("withOneEvent", new Rule(){{
			add("id", random(Long.class, range(1L, 3L)));
			add("name",random("participant 1"));
			add("events", has(1).of(Event.class,"first") );
		}});
				
		Fixture.of(Event.class).addTemplate("first",new Rule(){{
			add("id", 1L);
			add("name","event 1");
		}});
		
	}
	
	@Before
	public void before(){
		participant = new Participant();
		eventWithEmptyParticipants = new Event();
	}
	
	@Test
	public void shouldRegisterParticipantInEvent(){
		participant.addEvent(eventWithEmptyParticipants);
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotaddEventEventParticipantChecked(){
		Participant participant = Fixture.from(Participant.class).gimme("withOneEvent");
		Event event = Fixture.from(Event.class).gimme("first");
		participant.addEvent(event);
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotremoveEventEventPartipantNotChecked(){
		participant.removeEvent(eventWithEmptyParticipants);
	}
	
	@Test
	public void shouldremoveEventParticipantEvent(){
		Participant participant = Fixture.from(Participant.class).gimme("withOneEvent");
		Event event = Fixture.from(Event.class).gimme("first");
		participant.removeEvent(event);
	}
	
}
