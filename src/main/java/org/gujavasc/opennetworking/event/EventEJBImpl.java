package org.gujavasc.opennetworking.event;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.gujavasc.opennetworking.participant.Participant;
import org.gujavasc.opennetworking.participant.ParticipantRepository;

@Local(EventService.class)
@Stateless
public class EventEJBImpl implements EventService {

	@Inject
	private EventRepository repository;
	
	@Override
	public List<Event> findByName(String name){
		return repository.findByName(name);
	}
	
	@Override
	public Event findById(@NotNull Long id){
		return repository.findById(id);
	}
	
	@Override
	public void checkin(@NotNull Long eventId,@NotNull Long participantId){
		Event event = repository.findParticipants(eventId);
		Participant participant = getParticipantRepository().findById(participantId);
		event.checkin(participant);
		repository.save(event);
	}
	
	@Override
	public void checkout(Long eventId, Long participantId) {
		Event event = repository.findParticipants(eventId);
		Participant participant = getParticipantRepository().findById(participantId);
		event.checkout(participant);
		repository.save(event);
	}
	
	private ParticipantRepository getParticipantRepository(){
		return CDI.current().select(ParticipantRepository.class).get();
	}
	
}
