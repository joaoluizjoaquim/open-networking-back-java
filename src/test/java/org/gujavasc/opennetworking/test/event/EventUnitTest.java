package org.gujavasc.opennetworking.test.event;

import junit.framework.Assert;

import org.gujavasc.opennetworking.event.Event;
import org.gujavasc.opennetworking.event.Participant;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class EventUnitTest {

	
	@BeforeClass
	public static void preparteObjectFactory(){
		Fixture.of(Event.class).addTemplate("withOneParticipant", new Rule(){{
			add("id", random(Long.class, range(1L, 3L)));
			add("name","event 1");
			add("totalParticipants", 1L);
			add("participants", has(1).of(Participant.class,"first") );
		}});
				
		Fixture.of(Participant.class).addTemplate("first",new Rule(){{
			add("id", 1L);
			add("name", "participant 1");
		}});		
	}
	
	@Test
	public void shouldRegisterParticipantInEvent(){
		Event event = new Event(1L, "Event 1");
		Participant participant = new Participant();
		event.checkin(participant);
		Assert.assertEquals(event.getTotalParticipants(), Long.valueOf(1L));
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotCheckinEventParticipantChecked(){
		Event event = Fixture.from(Event.class).gimme("withOneParticipant");
		Participant participant = Fixture.from(Participant.class).gimme("first");
		event.checkin(participant);
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldNotCheckoutEventPartipantNotChecked(){
		Event event = new Event(1L, "Event 1");
		Participant participant = new Participant();
		event.checkout(participant);
	}
	
	@Test
	public void shouldCheckoutParticipantEvent(){
		Event event = Fixture.from(Event.class).gimme("withOneParticipant");
		Participant participant = Fixture.from(Participant.class).gimme("first");
		event.checkout(participant);
		Assert.assertEquals(event.getTotalParticipants(), Long.valueOf(0L));
	}
	
}
