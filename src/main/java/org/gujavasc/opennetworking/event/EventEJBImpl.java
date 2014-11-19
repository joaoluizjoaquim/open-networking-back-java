package org.gujavasc.opennetworking.event;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Local(EventService.class)
@Stateless
public class EventEJBImpl implements EventService {

	@Inject
	private EventRepository repository;

	public List<Event> findByName(String name){
		return repository.findByName(name);
	}
	
	public Event findById(Long id){
		return repository.findById(id);
	}
	
}
