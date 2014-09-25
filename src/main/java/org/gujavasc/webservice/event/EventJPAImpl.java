package org.gujavasc.webservice.event;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EventJPAImpl implements EventDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Event> findByName(String name) {
		ArrayList<Event> arrayList = new ArrayList<>();
		arrayList.add(new Event(1, "teste"));
		return arrayList;
	}

}
