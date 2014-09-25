package org.gujavasc.webservice.event;

import java.util.List;

public class EventEntityResource {

	private List<Event> allEventsByName;

	public EventEntityResource() {
	}
	
	public EventEntityResource(List<Event> allEventsByName) {
		this.allEventsByName = allEventsByName;
	}
	
	public List<Event> getEvents(){
		return allEventsByName;
	}

}
