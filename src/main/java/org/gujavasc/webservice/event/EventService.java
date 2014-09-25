package org.gujavasc.webservice.event;

import java.util.List;

public interface EventService {

	List<Event> findByName(String name);
	
	Event findById(Long id);
}
