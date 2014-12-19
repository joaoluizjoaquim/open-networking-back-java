package org.gujavasc.opennetworking.event;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@Local(ParticipantService.class)
@Stateless
public class ParticipantEJBImpl implements ParticipantService {

	@Inject
	private ParticipantRepository repository;
	
	@Override
	public Participant findById(@NotNull Long participantId) {
		return repository.findById(participantId);
	}

	@Override
	public void checkin(@NotNull Long eventId, @NotNull Long participantId) {
		Event event = getParticipantRepository().findById(eventId);
		Participant participant = repository.findByIdWithEvents(participantId);
		participant.addEvent(event);
		repository.update(participant);
	}

	@Override
	public void checkout(Long eventId, Long participantId) {
		Event event = getParticipantRepository().findById(eventId);
		Participant participant = repository.findByIdWithEvents(participantId);
		participant.removeEvent(event);
		repository.update(participant);
	}
	
	private EventRepository getParticipantRepository(){
		return CDI.current().select(EventRepository.class).get();
	}
	
}
