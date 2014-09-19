package org.gujavasc.webservice.event;

import java.util.ArrayList;
import java.util.List;

public interface EventEndpoint {
	
	public default List<Event> findByName(String name){
		return new ArrayList<>();
	}
}
