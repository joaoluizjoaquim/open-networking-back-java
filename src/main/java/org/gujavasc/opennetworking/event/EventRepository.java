package org.gujavasc.opennetworking.event;

import java.util.List;

public interface EventRepository {

	List<Event> findByName(String name);
	
	Event findById(Long id);
	
	Event findParticipants(Long id);
	
	void save(Event event);
	
	void update(Event event);

	List<Participant> findParticipantsBySkill(Long eventId, String skill);
	
}