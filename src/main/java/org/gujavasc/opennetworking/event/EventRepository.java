package org.gujavasc.opennetworking.event;

import java.util.List;

public interface EventRepository {

	List<Event> findByName(String name);
	
	Event findById(Long id);
	
	Event findParticipants(Long id);

}
