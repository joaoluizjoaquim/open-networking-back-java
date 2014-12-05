package org.gujavasc.opennetworking.test.participant;

import org.gujavasc.opennetworking.event.Participant;
import org.gujavasc.opennetworking.event.ParticipantService;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@Ignore
public class ParticipantEJBTest {

	private ParticipantService service;
	
	public static Archive<?> createDeployment(){
		WebArchive war = ShrinkWrap.create(WebArchive.class)
			.addPackage(Participant.class.getPackage())
			.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("data-load.sql","META-INF/data-load.sql")
            .addAsWebInfResource("jbossas-ds.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		return war;
	}
	
	@Test
	public void shouldFindParticipant(){
		service.findById(1L);
	}
	
}
