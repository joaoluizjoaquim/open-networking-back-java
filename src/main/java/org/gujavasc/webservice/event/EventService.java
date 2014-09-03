package org.gujavasc.webservice.event;

import java.util.List;

public interface EventService {

	public List<Event> findByName(String name);
}
