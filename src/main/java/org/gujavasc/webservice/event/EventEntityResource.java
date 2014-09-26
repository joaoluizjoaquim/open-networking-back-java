package org.gujavasc.webservice.event;

import java.util.List;

public class EventEntityResource extends AbstractEntityResource<Event> {

	private List<Event> allEventsByName;

	public EventEntityResource() {
	}
	
	public EventEntityResource(List<Event> allEventsByName) {
		entity = allEventsByName.get(0);
	}
	
	public List<Event> getEvents(){
		return allEventsByName;
	}

}
