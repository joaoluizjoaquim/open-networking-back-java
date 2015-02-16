package org.gujavasc.opennetworking.test.participant;

import javax.inject.Inject;

import org.gujavasc.opennetworking.event.Participant;
import org.gujavasc.opennetworking.event.ParticipantService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ParticipantEJBTest {

	@Inject
	private ParticipantService service;

	@Deployment
	public static Archive<?> createDeployment() {
		WebArchive war = ShrinkWrap
				.create(WebArchive.class)
				.addPackage(Participant.class.getPackage())
				.addAsResource("test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsResource("data-load.sql", "META-INF/data-load.sql")
				.addAsWebInfResource("jbossas-ds.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		return war;
	}

	@Test
	@InSequence(1)
	@UsingDataSet("simple_participant.yml")
	@Cleanup()
	public void shouldFindParticipantById() {
		Participant participant = service.findById(1L);
		Assert.assertNotNull(participant);
	}

}
