package org.gujavasc.opennetworking.event;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class EventJPAImpl implements EventRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Event> findByName(String name) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT new Event(e.id,e.name,count(p)) FROM Event e LEFT JOIN e.participants p "
				+ "WHERE upper(e.name) like :eventName "
				+ "GROUP BY e.id ");
		TypedQuery<Event> query = entityManager.createQuery(jpql.toString(),Event.class);
		query.setParameter("eventName", "%"+name.toUpperCase()+"%");
		return query.getResultList();
	}
	
	@Override
	public Event findById(Long id){
		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT new Event(e.id,e.name,count(p)) FROM Event e LEFT JOIN e.participants p WHERE e.id = :eventId ");
		TypedQuery<Event> query = entityManager.createQuery(jpql.toString(),Event.class);
		query.setParameter("eventId", id);
		return query.getSingleResult();
	}

	@Override
	public Event findParticipants(Long id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT e FROM Event e LEFT JOIN FETCH e.participants p WHERE e.id = :eventId ");
		TypedQuery<Event> query = entityManager.createQuery(jpql.toString(),Event.class);
		query.setParameter("eventId", id);
		return query.getSingleResult();
	}

}
