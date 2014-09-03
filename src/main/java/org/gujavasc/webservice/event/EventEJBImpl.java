package org.gujavasc.webservice.event;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Local(EventService.class)
@Stateless
public class EventEJBImpl implements EventService {

	@Inject
	private EventDAO dao;

	public List<Event> findByName(String name){
		return dao.findByName(name);
	}
	
}
