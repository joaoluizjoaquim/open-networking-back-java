package org.gujavasc.opennetworking.event;

import java.util.List;

public interface EventService {

	List<Event> findByName(String name);
	
	Event findById(Long id);
}
