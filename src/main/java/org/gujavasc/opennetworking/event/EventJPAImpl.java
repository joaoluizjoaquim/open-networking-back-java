package org.gujavasc.opennetworking.event;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

class EventJPAImpl implements EventRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
		
	@Override
	public List<Event> findByName(String name) {
		TypedQuery<Event> query = entityManager.createNamedQuery(Event.FIND_NAME,Event.class);
		query.setParameter("eventName", "%"+name.toUpperCase()+"%");
		return query.getResultList();
	}	
	
	
	@Override
	public Event findById(Long id){
		TypedQuery<Event> query = entityManager.createNamedQuery(Event.FIND_ID,Event.class);
		query.setParameter("eventId", id);
		return query.getSingleResult();
	}

	@Override
	public Event findParticipants(Long id) {
		TypedQuery<Event> query = entityManager.createNamedQuery(Event.FIND_PARTICIPANTS,Event.class);
		query.setParameter("eventId", id);
		return query.getSingleResult();
	}
	
	@Override
	public void save(Event event){
		if(event.getId() == null){
			entityManager.persist(event);
			return;
		}
		entityManager.merge(event);
	}

}
