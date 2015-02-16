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
		TypedQuery<Event> query = entityManager.createNamedQuery(Event.FIND_NAME, Event.class);
		query.setParameter("eventName", "%" + name.toUpperCase() + "%");
		return query.getResultList();
	}

	@Override
	public Event findById(Long id) {
		TypedQuery<Event> query = entityManager.createNamedQuery(Event.FIND_ID, Event.class);
		query.setParameter("eventId", id);
		return query.getSingleResult();
	}

	@Override
	public Event findParticipants(Long id) {
		TypedQuery<Event> query = entityManager.createNamedQuery( Event.FIND_PARTICIPANTS, Event.class);
		query.setParameter("eventId", id);
		return query.getSingleResult();
	}

	@Override
	public void save(Event event) {
		entityManager.persist(event);
	}

	@Override
	public void update(Event event){
		entityManager.merge(event);
	}
	
	@Override
	public List<Participant> findParticipantsBySkill(Long eventId, String skill) {
		TypedQuery<Participant> query = entityManager.createNamedQuery(Participant.FIND_SKILLS_EVENT, Participant.class);

		query.setParameter("eventId", eventId);
		query.setParameter("skill", "%" + skill.toUpperCase() + "%");
		return query.getResultList();
	}

}
