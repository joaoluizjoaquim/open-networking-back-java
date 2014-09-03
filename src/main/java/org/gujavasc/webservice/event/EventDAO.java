package org.gujavasc.webservice.event;

import java.util.List;

public interface EventDAO {

	public List<Event> findByName(String name);
	
}
